package com.HaiGorilla406.ecplus;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PlayerDataManager {

    private static File getPlayerFile(OfflinePlayer p) {
        File folder = new File(ECPlusPlugin.getInstance().getDataFolder(), "playerdata");
        if (!folder.exists()) folder.mkdirs();
        return new File(folder, p.getUniqueId().toString() + ".yml");
    }

    public static void saveInventory(OfflinePlayer p, int page, ItemStack[] contents) {
        File file = getPlayerFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        // Nur die ersten 45 Slots speichern
        ItemStack[] safe = new ItemStack[45];
        System.arraycopy(contents, 0, safe, 0, 45);

        config.set("page" + page, safe);

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ItemStack[] loadInventory(OfflinePlayer p, int page) {
        File file = getPlayerFile(p);
        if (!file.exists()) return null;

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        List<ItemStack> list = (List<ItemStack>) config.get("page" + page);
        if (list == null) return null;

        ItemStack[] contents = new ItemStack[54];

        for (int i = 0; i < 45; i++) {
            contents[i] = (i < list.size()) ? list.get(i) : null;
        }

        return contents;
    }
}