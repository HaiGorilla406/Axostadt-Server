package com.HaiGorilla406.ecplus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class ECCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player p = (Player) sender;

        // ---------------------------------------------------------
        // /ec  → eigene EC (jeder darf)
        // ---------------------------------------------------------
        if (args.length == 0) {

            p.setMetadata("ecplus_open", new FixedMetadataValue(ECPlusPlugin.getInstance(), true));
            new ECListener().openPage(p, p.getName(), 1);
            return true;
        }

        // ---------------------------------------------------------
        // /ec reload  → nur mit ecplus.reload
        // ---------------------------------------------------------
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {

            if (!p.hasPermission("ecplus.reload")) {
                p.sendMessage("§cDu hast keine Berechtigung für /ec reload.");
                return true;
            }

            ECPlusPlugin.getInstance().reloadECPlus();
            p.sendMessage("§aECPlus wurde erfolgreich neu geladen.");
            return true;
        }

        // ---------------------------------------------------------
        // /ec <spieler>  → nur mit ecplus.view.other
        // ---------------------------------------------------------
        if (args.length == 1) {

            if (!p.hasPermission("ecplus.view.other")) {
                p.sendMessage("§cDu darfst keine fremden Enderchests öffnen.");
                return true;
            }

            String target = args[0];

            p.setMetadata("ecplus_open", new FixedMetadataValue(ECPlusPlugin.getInstance(), true));
            new ECListener().openPage(p, target, 1);
            return true;
        }

        // ---------------------------------------------------------
        // /ec <spieler> <seite>  → nur mit ecplus.view.other
        // ---------------------------------------------------------
        if (args.length == 2) {

            if (!p.hasPermission("ecplus.view.other")) {
                p.sendMessage("§cDu darfst keine fremden Enderchests öffnen.");
                return true;
            }

            String target = args[0];
            int page;

            try {
                page = Integer.parseInt(args[1]);
            } catch (Exception e) {
                p.sendMessage("§cUngültige Seitenzahl.");
                return true;
            }

            p.setMetadata("ecplus_open", new FixedMetadataValue(ECPlusPlugin.getInstance(), true));
            new ECListener().openPage(p, target, page);
            return true;
        }

        p.sendMessage("§cBenutzung: /ec [spieler] [seite]");
        return true;
    }
}
