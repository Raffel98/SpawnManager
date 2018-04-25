package de.raffel98.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.raffel98.SpawnManager.Main;

public class setworldspawnCmd implements CommandExecutor {

	private Main plugin;

	public setworldspawnCmd(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("setworldspawn")){
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("SpawnManager.setspawnpoint")){
					p.getWorld().setSpawnLocation((int) p.getLocation().getX(), (int) p.getLocation().getY(), (int) p.getLocation().getZ());
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.PREFIX) + plugin.getConfig().getString("SpawnManager.Messanges.setworldspawn"));
					return true;
				}
			}else
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.PREFIX) + plugin.getConfig().getString("SpawnManager.Messanges.OnlyPlayers"));
		}
		return false;
	}

}
