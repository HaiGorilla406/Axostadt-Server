package com.HaiGorilla406.ecplus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class ECBlockListener implements Listener {

    private void runSync(Player p, Runnable task) {
        try {
            p.getScheduler().run(ECPlusPlugin.getInstance(), t -> task.run(), null);
        } catch (NoSuchMethodError ignored) {
            Bukkit.getScheduler().runTask(ECPlusPlugin.getInstance(), task);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = e.getClickedBlock();
        if (block == null) return;

        if (block.getType() != Material.ENDER_CHEST) return;

        Player p = e.getPlayer();

        // Vanilla Enderchest blockieren
        e.setCancelled(true);

        // Anti-Dup Lock setzen
        p.setMetadata("ecplus_open", new FixedMetadataValue(ECPlusPlugin.getInstance(), true));

        runSync(p, () -> {
            ECListener listener = new ECListener();
            listener.openPage(p, p.getName(), 1);
        });
    }
}