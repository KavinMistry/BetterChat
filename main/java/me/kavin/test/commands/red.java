package me.kavin.test.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class red implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;
        String name = player.getName();
        player.setDisplayName(ChatColor.RED + name);
        player.setPlayerListName(ChatColor.RED + name);

        return true;
    }
}
