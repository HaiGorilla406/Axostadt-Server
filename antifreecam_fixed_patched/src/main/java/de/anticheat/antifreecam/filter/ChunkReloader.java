package de.anticheat.antifreecam.filter;

import de.anticheat.antifreecam.AntiFreecam;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ChunkReloader implements Listener {

    private final AntiFreecam plugin;
    private final Map<UUID, Boolean> wasUnderPlayerY = new ConcurrentHashMap<>();
    private final Map<UUID, Long>    lastChunkKey    = new ConcurrentHashMap<>();
    private final Map<UUID, Long>    lastRefresh     = new ConcurrentHashMap<>();

    private static final int CHUNKS_PER_TICK          = 5;
    private static final int MIN_REFRESH_INTERVAL_MS  = 750;
    private static final int MAX_VIEW_DIST_FOR_REFRESH = 4;

    public ChunkReloader(AntiFreecam plugin) {
        this.plugin = plugin;
    }

    private boolean isWorldFiltered(Player player) {
        String worldName = player.getWorld().getName();
        List<String> blacklist = plugin.getConfig().getStringList("worlds.blacklist");
        List<String> whitelist = plugin.getConfig().getStringList("worlds.whitelist");
        if (!blacklist.isEmpty() && blacklist.contains(worldName)) return false;
        if (!whitelist.isEmpty() && !whitelist.contains(worldName)) return false;
        return true;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onMove(PlayerMoveEvent event) {
        if (event.getFrom().getBlockY() == event.getTo().getBlockY()) return;
        Player player = event.getPlayer();
        if (player.hasPermission("antifreecam.bypass")) return;
        if (!isWorldFiltered(player)) return;
        handleYChange(player);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onTeleport(PlayerTeleportEvent event) {
        if (event.getTo() == null) return;
        Player player = event.getPlayer();
        if (player.hasPermission("antifreecam.bypass")) return;

        int playerLoadY = plugin.getConfig().getInt("filtering.player-load-y", 20);
        boolean destIsUnder = event.getTo().getY() < playerLoadY;

        wasUnderPlayerY.put(player.getUniqueId(), destIsUnder);
        lastChunkKey.remove(player.getUniqueId());
        lastRefresh.remove(player.getUniqueId());
        plugin.getChunkFilter().setReceiveRealChunks(player.getUniqueId(), destIsUnder);

        // Nach dem Teleport: Chunks erzwingen durch refreshChunk im RegionScheduler
        // + re-teleport auf gleiche Position damit Server Chunk-Radius neu berechnet
        scheduleForceRefresh(player, 20L);
        scheduleForceRefresh(player, 60L);
    }

    private void handleYChange(Player player) {
        int playerLoadY = plugin.getConfig().getInt("filtering.player-load-y", 20);
        boolean nowUnder = player.getLocation().getBlockY() < playerLoadY;
        boolean wasUnder = wasUnderPlayerY.getOrDefault(player.getUniqueId(), false);

        if (nowUnder && !wasUnder) {
            wasUnderPlayerY.put(player.getUniqueId(), true);
            plugin.getChunkFilter().setReceiveRealChunks(player.getUniqueId(), true);
            scheduleThrottledRefresh(player, 2L);
        } else if (!nowUnder && wasUnder) {
            wasUnderPlayerY.put(player.getUniqueId(), false);
            plugin.getChunkFilter().setReceiveRealChunks(player.getUniqueId(), false);
            scheduleThrottledRefresh(player, 2L);
        }

        if (nowUnder) {
            int cx = player.getLocation().getChunk().getX();
            int cz = player.getLocation().getChunk().getZ();
            long key = ((long) cx << 32) | (cz & 0xFFFFFFFFL);
            Long last = lastChunkKey.get(player.getUniqueId());
            if (last == null || last != key) {
                lastChunkKey.put(player.getUniqueId(), key);
                scheduleThrottledRefresh(player, 2L);
            }
        }
    }

    private void scheduleThrottledRefresh(Player player, long delayTicks) {
        long now = System.currentTimeMillis();
        Long last = lastRefresh.get(player.getUniqueId());
        if (last != null && (now - last) < MIN_REFRESH_INTERVAL_MS) return;
        lastRefresh.put(player.getUniqueId(), now);
        doRefreshBatch(player, delayTicks);
    }

    private void scheduleForceRefresh(Player player, long delayTicks) {
        player.getScheduler().runDelayed(plugin, task -> {
            if (!player.isOnline()) return;
            if (!isWorldFiltered(player)) return;
            lastRefresh.remove(player.getUniqueId());

            // Spieler auf exakt gleiche Position re-teleportieren.
            // Das zwingt den Server den kompletten Chunk-View-Radius neu zu senden –
            // zuverlässiger als refreshChunk() weil der Server selbst entscheidet
            // welche Chunks fehlen. Der Filter greift beim Neuversand korrekt.
            Location loc = player.getLocation();
            player.teleport(loc, PlayerTeleportEvent.TeleportCause.PLUGIN);

        }, null, delayTicks);
    }

    private void doRefreshBatch(Player player, long delayTicks) {
        player.getScheduler().runDelayed(plugin, task -> {
            if (!player.isOnline()) return;

            int viewDist = Math.min(player.getClientViewDistance(), MAX_VIEW_DIST_FOR_REFRESH);
            int cx = player.getLocation().getChunk().getX();
            int cz = player.getLocation().getChunk().getZ();
            final World world = player.getWorld();

            List<int[]> chunks = new ArrayList<>();
            for (int dx = -viewDist; dx <= viewDist; dx++)
                for (int dz = -viewDist; dz <= viewDist; dz++)
                    chunks.add(new int[]{cx + dx, cz + dz});

            sendChunksBatch(player, world, chunks, new AtomicInteger(0));
        }, null, delayTicks);
    }

    private void sendChunksBatch(Player player, World world, List<int[]> chunks, AtomicInteger index) {
        if (!player.isOnline()) return;

        int start = index.get();
        int end   = Math.min(start + CHUNKS_PER_TICK, chunks.size());

        for (int i = start; i < end; i++) {
            final int fx = chunks.get(i)[0];
            final int fz = chunks.get(i)[1];

            plugin.getServer().getRegionScheduler().run(plugin, world, fx, fz, t -> {
                if (!player.isOnline()) return;
                if (world.isChunkLoaded(fx, fz)) {
                    world.refreshChunk(fx, fz);
                } else {
                    world.getChunkAtAsync(fx, fz).thenAccept(chunk ->
                        plugin.getServer().getRegionScheduler().run(plugin, world, fx, fz, t2 -> {
                            if (player.isOnline()) world.refreshChunk(fx, fz);
                        })
                    );
                }
            });
        }

        index.set(end);
        if (end < chunks.size()) {
            player.getScheduler().runDelayed(plugin, t ->
                sendChunksBatch(player, world, chunks, index), null, 1L);
        }
    }

    public void removePlayer(UUID uuid) {
        wasUnderPlayerY.remove(uuid);
        lastChunkKey.remove(uuid);
        lastRefresh.remove(uuid);
        plugin.getChunkFilter().setReceiveRealChunks(uuid, false);
    }
}
