package de.raffel98.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.raffel98.SpawnManager.Main;

public class SMCmd implements CommandExecutor {

	private Main plugin;

	public SMCmd(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("SM")) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reloade")) {
					if (sender.hasPermission("SpawnManager.SM.*") | sender.hasPermission("SpawnManager.SM.reloade")) {
						plugin.reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.PREFIX) + plugin.getConfig().getString("SpawnManager.Messanges.Reloade"));
						return true;
					}
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.PREFIX) + plugin.getConfig().getString("SpawnManager.Messanges.NeedArgs"));
			}
		}
		return false;
	}

}
