package com.HaiGorilla406.ecplus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ECListener implements Listener {

    private ItemStack arrow(String name) {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    private boolean isEC(String title) {
        return title.startsWith("ECPlus |");
    }

    private int getPage(String title) {
        try {
            return Integer.parseInt(title.split("\\|")[2].replaceAll("[^0-9]", "").trim());
        } catch (Exception e) {
            return 1;
        }
    }

    private String getTarget(String title) {
        try {
            return title.split("\\|")[1].trim();
        } catch (Exception e) {
            return "unknown";
        }
    }

    // ---------------------------------------------------------
    // OPEN PAGE
    // ---------------------------------------------------------
    public void openPage(Player viewer, String targetName, int page) {

        if (!viewer.isOp()) {
            if (page > 1) {
                String perm = "ecplus.pages." + page;
                if (!viewer.hasPermission(perm)) {
                    viewer.sendMessage("§cDu hast keine Berechtigung für Seite " + page + ".");
                    return;
                }
            }
        }

        if (page > ECPlusPlugin.MAX_PAGES) {
            viewer.sendMessage("§cDiese Seite existiert nicht.");
            return;
        }

        OfflinePlayer target = Bukkit.getOfflinePlayer(targetName);
        ItemStack[] contents = PlayerDataManager.loadInventory(target, page);

        String title = "ECPlus | " + targetName + " | " + page;

        Inventory inv = Bukkit.createInventory(null, 54, title);

        if (contents != null)
            inv.setContents(contents);

        inv.setItem(45, arrow("§e← Zurück"));
        inv.setItem(49, null);
        inv.setItem(53, arrow("§eWeiter →"));

        viewer.openInventory(inv);
    }

    // ---------------------------------------------------------
    // CLICK HANDLING
    // ---------------------------------------------------------
    @EventHandler
    public void onClick(InventoryClickEvent e) {

        String title = e.getView().getTitle();
        if (!isEC(title)) return;

        Player p = (Player) e.getWhoClicked();
        Inventory top = e.getView().getTopInventory();

        // WICHTIG: Prüfen, ob im TOP-Inventar geklickt wurde
        if (e.getClickedInventory() != top) {
            return; // Spielerinventar → frei
        }

        int raw = e.getRawSlot();
        int page = getPage(title);
        String target = getTarget(title);

        // ---------------------------------------------------------
        // NUR Navigation blockieren
        // ---------------------------------------------------------
        if (raw == 45 || raw == 53) {
            e.setCancelled(true);

            if (raw == 45 && page > 1) openPage(p, target, page - 1);
            if (raw == 53 && page < ECPlusPlugin.MAX_PAGES) openPage(p, target, page + 1);

            return;
        }

        // ---------------------------------------------------------
        // Nur Offhand-Swap blockieren
        // ---------------------------------------------------------
        if (e.getClick() == ClickType.SWAP_OFFHAND) {
            e.setCancelled(true);
            return;
        }

        // ---------------------------------------------------------
        // SAVE ON MOVE (nur Top-Inventar)
        // ---------------------------------------------------------
        Bukkit.getScheduler().runTask(ECPlusPlugin.getInstance(), () -> {

            OfflinePlayer off = Bukkit.getOfflinePlayer(target);
            ItemStack[] contents = top.getContents();

            contents[45] = null;
            contents[49] = null;
            contents[53] = null;

            PlayerDataManager.saveInventory(off, page, contents);
        });
    }

    // ---------------------------------------------------------
    // CLOSE EVENT
    // ---------------------------------------------------------
    @EventHandler
    public void onClose(InventoryCloseEvent e) {

        String title = e.getView().getTitle();
        if (!isEC(title)) return;

        Inventory inv = e.getInventory();
        if (inv.getSize() != 54) return;

        int page = getPage(title);
        String target = getTarget(title);
        OfflinePlayer off = Bukkit.getOfflinePlayer(target);

        ItemStack[] contents = inv.getContents();

        contents[45] = null;
        contents[49] = null;
        contents[53] = null;

        Bukkit.getScheduler().runTask(ECPlusPlugin.getInstance(), () ->
                PlayerDataManager.saveInventory(off, page, contents)
        );
    }
}
