package me.nciklol.easytpa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CommandTPAccept implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            UUID originalPlayer = Main.tpPlayers.get(player.getUniqueId());

            if (originalPlayer == null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have any requests."));
                return true;
            }

            Player player2 = Bukkit.getPlayer(originalPlayer);

            if (player2 == null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&bCannot find player!"));
                Main.tpPlayers.remove(player.getUniqueId());
                CommandTPA.securityTable.remove(player.getUniqueId());
                return true;
            }

            player2.teleport(player);
            player2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aTeleported!"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccess!"));

            Main.tpPlayers.remove(player.getUniqueId());
            CommandTPA.securityTable.remove(player.getUniqueId());
            return true;

        }

        commandSender.sendMessage("You need to be a player to use this command!");
        return false;
    }
}
