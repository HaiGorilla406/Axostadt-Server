package de.anticheat.antifreecam.filter;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import de.anticheat.antifreecam.AntiFreecam;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Filtert ALLE Entity-Spawn-Packets für Spieler die ÜBER der Y-Grenze sind.
 *
 * FIX: Config-Werte werden gecacht statt bei jedem Paket neu aus der Config gelesen.
 */
public class EntityPacketFilter extends PacketListenerAbstract {

    private final AntiFreecam plugin;

    // Gecachte Config-Werte
    private volatile boolean enabled;
    private volatile int     hideBelowY;
    private volatile boolean debug;

    public EntityPacketFilter(AntiFreecam plugin) {
        super(PacketListenerPriority.NORMAL);
        this.plugin = plugin;
        reloadConfig();
    }

    public void reloadConfig() {
        enabled    = plugin.getConfig().getBoolean("filtering.enabled", true);
        hideBelowY = plugin.getConfig().getInt("filtering.hide-below-y", 1);
        debug      = plugin.getConfig().getBoolean("advanced.debug", false);
    }

    @Override
    public void onPacketSend(PacketSendEvent event) {
        if (!enabled) return;
        if (event.getPacketType() != PacketType.Play.Server.SPAWN_ENTITY) return;

        UUID uuid = event.getUser().getUUID();
        if (uuid == null) return;
        if (plugin.isBypass(uuid)) return;

        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        if (player.hasPermission("antifreecam.bypass")) return;

        if (player.getLocation().getBlockY() < hideBelowY) return;

        try {
            WrapperPlayServerSpawnEntity wrapper = new WrapperPlayServerSpawnEntity(event);
            double entityY = wrapper.getPosition().getY();
            if (entityY >= hideBelowY) return;

            if (wrapper.getEntityType() != EntityTypes.PLAYER) {
                event.setCancelled(true);
            }
        } catch (Exception e) {
            if (debug) {
                plugin.getLogger().warning("[AF] Entity-Filter Fehler: " + e.getMessage());
            }
        }
    }
}
