package de.anticheat.antifreecam;

import com.github.retrooper.packetevents.PacketEvents;
import de.anticheat.antifreecam.commands.AfCommand;
import de.anticheat.antifreecam.filter.ChunkPacketFilter;
import de.anticheat.antifreecam.filter.ChunkReloader;
import de.anticheat.antifreecam.filter.EntityPacketFilter;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class AntiFreecam extends JavaPlugin {

    private static AntiFreecam instance;
    private ChunkPacketFilter  chunkFilter;
    private EntityPacketFilter entityFilter;
    private ChunkReloader      chunkReloader;

    private final Set<UUID> bypassPlayers = ConcurrentHashMap.newKeySet();

    /**
     * FIX: LongAdder statt synchronized long – deutlich schneller bei vielen gleichzeitigen Threads
     * (Netty-Threads schreiben hier extrem häufig rein)
     */
    private final LongAdder packetsProcessed = new LongAdder();
    private final LongAdder sectionsFiltered = new LongAdder();

    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        getLogger().info("AntiFreecam v" + getDescription().getVersion() + " wird gestartet...");

        chunkFilter  = new ChunkPacketFilter(this);
        entityFilter = new EntityPacketFilter(this);
        PacketEvents.getAPI().getEventManager().registerListener(chunkFilter);
        PacketEvents.getAPI().getEventManager().registerListener(entityFilter);

        getServer().getGlobalRegionScheduler().execute(this, () -> {
            try {
                PacketEvents.getAPI().init();
                getLogger().info("PacketEvents erfolgreich initialisiert.");
            } catch (Exception e) {
                getLogger().severe("Fehler bei PacketEvents-Initialisierung: " + e.getMessage());
                getLogger().severe("Stelle sicher, dass PacketEvents als Plugin installiert ist!");
            }
        });

        chunkReloader = new ChunkReloader(this);
        getServer().getPluginManager().registerEvents(chunkReloader, this);
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        AfCommand cmd = new AfCommand(this);
        getCommand("antifreecam").setExecutor(cmd);
        getCommand("antifreecam").setTabCompleter(cmd);
        getCommand("af").setExecutor(cmd);
        getCommand("af").setTabCompleter(cmd);

        int statsInterval = getConfig().getInt("advanced.stats-interval-seconds", 0);
        if (statsInterval > 0) {
            getServer().getAsyncScheduler().runAtFixedRate(
                    this,
                    task -> getLogger().info("[Stats] Pakete: " + packetsProcessed.sum()
                            + " | Sections: " + sectionsFiltered.sum()),
                    statsInterval, statsInterval, TimeUnit.SECONDS
            );
        }

        getLogger().info("AntiFreecam aktiv! Blöcke + Entities unter Y=" +
                getConfig().getInt("filtering.hide-below-y", 1) + " werden gefiltert.");
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().terminate();
    }

    public void reloadPluginConfig() {
        reloadConfig();
        chunkFilter.reloadConfig();
        entityFilter.reloadConfig();
    }

    public boolean isBypass(UUID uuid)  { return bypassPlayers.contains(uuid); }
    public void addBypass(UUID uuid)    { bypassPlayers.add(uuid); }
    public void removeBypass(UUID uuid) { bypassPlayers.remove(uuid); }

    // FIX: LongAdder.increment() ist lock-frei → kein synchronized nötig
    public void incrementPackets()           { packetsProcessed.increment(); }
    public void incrementSections(int count) { sectionsFiltered.add(count); }

    public ChunkReloader    getChunkReloader() { return chunkReloader; }
    public static AntiFreecam getInstance()    { return instance; }
    public ChunkPacketFilter getChunkFilter()  { return chunkFilter; }
}
