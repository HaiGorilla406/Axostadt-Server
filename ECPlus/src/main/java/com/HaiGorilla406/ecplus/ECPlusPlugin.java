package com.HaiGorilla406.ecplus;

import org.bukkit.plugin.java.JavaPlugin;

public class ECPlusPlugin extends JavaPlugin {

    private static ECPlusPlugin instance;

    public static int MAX_PAGES = 3;

    public static ECPlusPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        // Config laden
        saveDefaultConfig();
        loadSettings();

        // Sprachen laden
        MessageManager.load(this);

        // Listener registrieren
        getServer().getPluginManager().registerEvents(new ECListener(), this);
        getServer().getPluginManager().registerEvents(new ECBlockListener(), this);

        // Command registrieren
        getCommand("ec").setExecutor(new ECCommand());

        getLogger().info("ECPlus enabled with " + MAX_PAGES + " pages.");
    }

    public void reloadECPlus() {
        reloadConfig();
        loadSettings();
        MessageManager.load(this);
        getLogger().info("ECPlus reloaded. Pages: " + MAX_PAGES);
    }

    private void loadSettings() {
        MAX_PAGES = getConfig().getInt("settings.max-pages", 3);
    }
}
