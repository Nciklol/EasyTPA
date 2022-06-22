package me.nciklol.easytpa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static Map<UUID, UUID> tpPlayers = new HashMap();

    @Override
    public void onEnable() {
        this.getCommand("tpa").setExecutor(new CommandTPA());
        this.getCommand("tpaccept").setExecutor(new CommandTPAccept());
        Bukkit.getLogger().info(ChatColor.GREEN + "Enabled " + this.getName());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.RED + "Disabled " + this.getName());
    }


}
