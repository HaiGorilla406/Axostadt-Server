package de.anticheat.antifreecam.commands;

import de.anticheat.antifreecam.AntiFreecam;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AfCommand implements CommandExecutor, TabCompleter {

    private final AntiFreecam plugin;

    public AfCommand(AntiFreecam plugin) {
        this.plugin = plugin;
    }

    private void send(CommandSender sender, String msg) {
        String prefix = plugin.getConfig().getString("messages.prefix", "&8[&bAF&8] &r");
        sender.sendMessage(LegacyComponentSerializer.legacyAmpersand().deserialize(prefix + msg));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("antifreecam.admin")) {
            send(sender, "&cKeine Berechtigung.");
            return true;
        }

        if (args.length == 0) {
            sendHelp(sender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "reload" -> {
                plugin.reloadPluginConfig();
                send(sender, plugin.getConfig().getString("messages.reload-success", "&aKonfiguration neu geladen."));
            }
            case "world" -> {
                if (sender instanceof Player p) {
                    send(sender, "&7Exakter Weltname: &f\"" + p.getWorld().getName() + "\"");
                } else {
                    send(sender, "&cNur fuer Spieler.");
                }
            }
            case "status" -> {
                boolean enabled = plugin.getConfig().getBoolean("filtering.enabled", true);
                int y = plugin.getConfig().getInt("filtering.hide-below-y", 0);
                String block = plugin.getConfig().getString("filtering.replacement-block", "stone");
                send(sender, "&7Status: " + (enabled ? "&aAktiv" : "&cDeaktiviert"));
                send(sender, "&7Y-Filter: &fUnter Y=" + y + " &8→ &f" + block);
                send(sender, "&7Welten-Blacklist: &f" + plugin.getConfig().getStringList("worlds.blacklist"));
                if (sender instanceof Player p) {
                    String wn = p.getWorld().getName();
                    boolean bl = plugin.getConfig().getStringList("worlds.blacklist").contains(wn);
                    send(sender, "&7Deine Welt: &f\"" + wn + "\" &8-> " + (bl ? "&cNicht gefiltert (Whitelist)" : "&aWird gefiltert"));
                }
            }
            case "toggle" -> {
                if (args.length < 2) {
                    boolean current = plugin.getConfig().getBoolean("filtering.enabled", true);
                    plugin.getConfig().set("filtering.enabled", !current);
                    plugin.saveConfig();
                    plugin.getChunkFilter().reloadConfig();
                    send(sender, !current
                            ? plugin.getConfig().getString("messages.filtering-enabled", "&aFilterung aktiviert.")
                            : plugin.getConfig().getString("messages.filtering-disabled", "&cFilterung deaktiviert."));
                } else {
                    // Toggle bypass for player
                    Player target = plugin.getServer().getPlayer(args[1]);
                    if (target == null) {
                        send(sender, "&cSpieler nicht gefunden.");
                        return true;
                    }
                    if (plugin.isBypass(target.getUniqueId())) {
                        plugin.removeBypass(target.getUniqueId());
                        send(sender, plugin.getConfig().getString("messages.player-bypass-off",
                                "&e%player% &7hat keinen Bypass mehr.").replace("%player%", target.getName()));
                    } else {
                        plugin.addBypass(target.getUniqueId());
                        send(sender, plugin.getConfig().getString("messages.player-bypass-on",
                                "&e%player% &7hat jetzt Bypass.").replace("%player%", target.getName()));
                        send(sender, "&8(Hinweis: Bypass gilt nur für diese Session, nicht dauerhaft)");
                    }
                }
            }
            default -> sendHelp(sender);
        }
        return true;
    }

    private void sendHelp(CommandSender sender) {
        send(sender, "&7=== AntiFreecam v2 ===");
        send(sender, "&b/af status &7- Aktuellen Status anzeigen");
        send(sender, "&b/af toggle &7- Filterung ein/ausschalten");
        send(sender, "&b/af toggle <Spieler> &7- Bypass für Spieler umschalten");
        send(sender, "&b/af reload &7- Konfiguration neu laden");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!sender.hasPermission("antifreecam.admin")) return Collections.emptyList();
        if (args.length == 1) {
            return List.of("status", "toggle", "reload", "world").stream()
                    .filter(s -> s.startsWith(args[0].toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("toggle")) {
            return plugin.getServer().getOnlinePlayers().stream()
                    .map(Player::getName)
                    .filter(n -> n.toLowerCase().startsWith(args[1].toLowerCase()))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
