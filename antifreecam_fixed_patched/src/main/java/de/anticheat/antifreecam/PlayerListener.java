package de.anticheat.antifreecam;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private final AntiFreecam plugin;

    public PlayerListener(AntiFreecam plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("antifreecam.bypass")) {
            plugin.addBypass(event.getPlayer().getUniqueId());
        } else {
            plugin.removeBypass(event.getPlayer().getUniqueId());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onQuit(PlayerQuitEvent event) {
        plugin.removeBypass(event.getPlayer().getUniqueId());
        plugin.getChunkReloader().removePlayer(event.getPlayer().getUniqueId());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onWorldChange(PlayerChangedWorldEvent event) {
        // State zurücksetzen wenn Spieler die Welt wechselt
        // (z.B. Overworld -> Nether) damit receiveRealChunks nicht
        // aus der alten Welt übrig bleibt
        plugin.getChunkReloader().removePlayer(event.getPlayer().getUniqueId());
    }
}
