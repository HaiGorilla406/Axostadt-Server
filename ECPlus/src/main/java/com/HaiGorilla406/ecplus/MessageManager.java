package com.HaiGorilla406.ecplus;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MessageManager {

    private static final Map<String, YamlConfiguration> languages = new HashMap<>();
    private static YamlConfiguration fallback;
    private static String configLanguage;

    public static void load(JavaPlugin plugin) {

        // Sprache aus config laden
        configLanguage = plugin.getConfig().getString("language", "auto").toLowerCase();

        File langFolder = new File(plugin.getDataFolder(), "lang");
        if (!langFolder.exists()) langFolder.mkdirs();

        // Liste aller Sprachdateien
        String[] files = {
                "de_de.yml", "en_us.yml", "en_gb.yml", "fr_fr.yml", "es_es.yml", "es_mx.yml",
                "pt_br.yml", "pt_pt.yml", "pl_pl.yml", "nl_nl.yml", "it_it.yml", "cs_cz.yml",
                "sk_sk.yml", "hu_hu.yml", "sv_se.yml", "da_dk.yml", "nb_no.yml", "fi_fi.yml",
                "el_gr.yml", "uk_ua.yml", "ru_ru.yml", "ro_ro.yml", "bg_bg.yml", "hr_hr.yml",
                "sr_sp.yml", "he_il.yml", "ar_sa.yml", "ja_jp.yml", "ko_kr.yml", "zh_cn.yml",
                "zh_tw.yml"
        };

        // Sprachdateien aus der JAR extrahieren (nur wenn sie fehlen)
        for (String fileName : files) {
            File outFile = new File(langFolder, fileName);
            if (!outFile.exists()) {
                plugin.saveResource("lang/" + fileName, false);
            }
        }

        // Fallback laden (Deutsch)
        File fallbackFile = new File(langFolder, "de_de.yml");
        fallback = YamlConfiguration.loadConfiguration(fallbackFile);
        languages.put("de_de", fallback);

        // Alle Dateien laden
        for (File file : langFolder.listFiles()) {
            if (!file.getName().endsWith(".yml")) continue;

            String lang = file.getName().replace(".yml", "").toLowerCase();
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            languages.put(lang, cfg);
        }

        System.out.println("[ECPlus] Loaded languages: " + languages.keySet());
    }

    private static String detectPlayerLang(Player p) {
        String locale = p.locale().toString().toLowerCase(); // z.B. de_de, en_us

        // Wenn Datei existiert → nutzen
        if (languages.containsKey(locale)) return locale;

        // Nur Sprachcode prüfen (z.B. "de")
        String shortCode = locale.split("_")[0];
        for (String lang : languages.keySet()) {
            if (lang.startsWith(shortCode)) return lang;
        }

        // Fallback
        return "de_de";
    }

    public static String get(Player p, String key) {
        String lang;

        // Server erzwingt Sprache
        if (!configLanguage.equals("auto")) {
            lang = configLanguage;
        } else {
            lang = detectPlayerLang(p);
        }

        YamlConfiguration cfg = languages.getOrDefault(lang, fallback);

        String msg = cfg.getString(key);

        if (msg == null) {
            msg = fallback.getString(key, "§cMissing translation: " + key);
        }

        return msg;
    }

    public static String getRaw(String key) {
        return fallback.getString(key, key);
    }
}
