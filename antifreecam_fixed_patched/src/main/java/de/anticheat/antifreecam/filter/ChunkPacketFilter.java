package de.anticheat.antifreecam.filter;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.world.chunk.BaseChunk;
import com.github.retrooper.packetevents.protocol.world.chunk.Column;
import com.github.retrooper.packetevents.protocol.world.chunk.NibbleArray3d;
import com.github.retrooper.packetevents.protocol.world.chunk.impl.v_1_18.Chunk_v1_18;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerChunkData;
import de.anticheat.antifreecam.AntiFreecam;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ChunkPacketFilter extends PacketListenerAbstract {

    private final AntiFreecam plugin;

    private final Set<UUID> receiveRealChunks = ConcurrentHashMap.newKeySet();

    // Gecachte Config-Werte
    private volatile boolean      enabled;
    private volatile int          hideBelowY;
    
    private volatile boolean      debug;
    private volatile boolean      onlyWhenUnderground;
    private volatile List<String> worldWhitelist;
    private volatile List<String> worldBlacklist;

    private static final int REPLACEMENT_STATE = 0; // Air

    private static final int WORLD_MIN_Y    = -64;
    private static final int SECTION_HEIGHT = 16;
    private static final int TOTAL_SECTIONS = 24;

    // Gecachte Reflection-Felder für Light-Nibble-Arrays in Chunk_v1_18
    private volatile Field blockLightField = null;
    private volatile Field skyLightField   = null;
    private volatile boolean lightFieldsResolved = false;

    public ChunkPacketFilter(AntiFreecam plugin) {
        super(PacketListenerPriority.NORMAL);
        this.plugin = plugin;
        reloadConfig();
    }

    public void reloadConfig() {
        enabled        = plugin.getConfig().getBoolean("filtering.enabled", true);
        hideBelowY     = plugin.getConfig().getInt("filtering.hide-below-y", 0);

        debug          = plugin.getConfig().getBoolean("advanced.debug", false);
        worldWhitelist = plugin.getConfig().getStringList("worlds.whitelist");
        worldBlacklist         = plugin.getConfig().getStringList("worlds.blacklist");
        onlyWhenUnderground    = plugin.getConfig().getBoolean("filtering.only-when-underground", false);
        lightFieldsResolved = false;
        blockLightField = null;
        skyLightField   = null;
    }

    public void setReceiveRealChunks(UUID uuid, boolean real) {
        if (real) receiveRealChunks.add(uuid);
        else      receiveRealChunks.remove(uuid);
    }

    public void removePlayer(UUID uuid) {
        receiveRealChunks.remove(uuid);
    }

    @Override
    public void onPacketSend(PacketSendEvent event) {
        if (!enabled) return;
        if (event.getPacketType() != PacketType.Play.Server.CHUNK_DATA) return;

        UUID uuid = event.getUser().getUUID();
        if (uuid == null) return;
        if (plugin.isBypass(uuid)) return;

        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        if (player.hasPermission("antifreecam.bypass")) return;

        String worldName = player.getWorld().getName();
        if (!worldBlacklist.isEmpty() && worldBlacklist.contains(worldName)) return;
        if (!worldWhitelist.isEmpty() && !worldWhitelist.contains(worldName)) return;

        if (receiveRealChunks.contains(uuid)) return;
        // only-when-underground: wenn true, nur filtern wenn Spieler selbst unter hideBelowY ist
        if (onlyWhenUnderground && player.getLocation().getBlockY() < hideBelowY) return;

        try {
            WrapperPlayServerChunkData wrapper = new WrapperPlayServerChunkData(event);
            Column column = wrapper.getColumn();
            BaseChunk[] chunks = column.getChunks();
            if (chunks == null) return;

            int filtered = 0;
            for (int i = 0; i < chunks.length && i < TOTAL_SECTIONS; i++) {
                int sectionMaxY = WORLD_MIN_Y + (i * SECTION_HEIGHT) + SECTION_HEIGHT - 1;
                if (sectionMaxY >= hideBelowY) continue;
                if (chunks[i] == null) continue;

                fillSection(chunks[i]);
                filtered++;
            }

            if (filtered > 0) {
                event.markForReEncode(true);
                plugin.incrementPackets();
                plugin.incrementSections(filtered);
                if (debug) plugin.getLogger().info("[Debug] Chunk gefiltert für " + player.getName() + " (" + filtered + " Sections)");
            }

        } catch (Exception e) {
            if (debug) {
                plugin.getLogger().warning("[AF] Fehler: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void fillSection(BaseChunk section) {
        // 1. Alle Block-States auf Bedrock setzen (inkl. Lava/Wasser Block-States)
        //    Bedrock = State 33, blockiert Light vollständig
        if (section instanceof Chunk_v1_18 chunk) {
            for (int x = 0; x < 16; x++)
                for (int y = 0; y < 16; y++)
                    for (int z = 0; z < 16; z++)
                        chunk.set(null, x, y, z, REPLACEMENT_STATE);
        } else {
            try {
                for (int x = 0; x < 16; x++)
                    for (int y = 0; y < 16; y++)
                        for (int z = 0; z < 16; z++)
                            section.set(null, x, y, z, REPLACEMENT_STATE);
            } catch (Exception e) {
                if (debug) plugin.getLogger().warning("[AF] set() Fehler: " + e.getMessage());
            }
        }

        // 2. Light-Daten löschen damit Lava-Licht nicht durch Bedrock hindurch leuchtet.
        //    Lava hat BlockLight-Level 15 – dieses wird im LightUpdatePacket aber SEPARAT
        //    gesendet, nicht im ChunkData. Trotzdem: Falls Light-Nibbles im ChunkData enthalten
        //    sind (1.17 und früher) müssen wir sie leeren.
        clearLightNibbles(section);
    }

    /**
     * Löscht BlockLight und SkyLight Nibble-Arrays der Section.
     * In 1.18+ werden Light-Daten über ein separates Paket gesendet,
     * aber für ältere Versionen und als Sicherheitsnetz leeren wir sie hier trotzdem.
     */
    private void clearLightNibbles(BaseChunk section) {
        try {
            if (!lightFieldsResolved) {
                lightFieldsResolved = true;
                blockLightField = findFieldByType(section.getClass(), NibbleArray3d.class, "blockLight", "block_light", "blocklight");
                skyLightField   = findFieldByType(section.getClass(), NibbleArray3d.class, "skyLight", "sky_light", "skylight");
                if (blockLightField != null) blockLightField.setAccessible(true);
                if (skyLightField   != null) skyLightField.setAccessible(true);
            }

            if (blockLightField != null) {
                NibbleArray3d arr = (NibbleArray3d) blockLightField.get(section);
                if (arr != null) java.util.Arrays.fill(arr.getData(), (byte) 0);
            }
            if (skyLightField != null) {
                NibbleArray3d arr = (NibbleArray3d) skyLightField.get(section);
                if (arr != null) java.util.Arrays.fill(arr.getData(), (byte) 0);
            }
        } catch (Exception e) {
            if (debug) plugin.getLogger().warning("[AF] clearLightNibbles Fehler: " + e.getMessage());
        }
    }

    private Field findFieldByType(Class<?> clazz, Class<?> fieldType, String... nameHints) {
        while (clazz != null && clazz != Object.class) {
            // Zuerst nach bekannten Namen suchen
            for (String hint : nameHints) {
                try {
                    Field f = clazz.getDeclaredField(hint);
                    if (fieldType.isAssignableFrom(f.getType())) return f;
                } catch (NoSuchFieldException ignored) {}
            }
            // Dann alle Felder des Typs durchsuchen
            for (Field f : clazz.getDeclaredFields()) {
                if (fieldType.isAssignableFrom(f.getType())) return f;
            }
            clazz = clazz.getSuperclass();
        }
        return null;
    }
}
