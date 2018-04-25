package de.raffel98.SpawnManager;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.raffel98.cmds.SMCmd;
import de.raffel98.cmds.setworldspawnCmd;

public class Main extends JavaPlugin implements Listener{

	public String PREFIX = "[SpawnManager] ";
	@Override
	public void onEnable(){
		System.out.println("[SpawnManager] Plugin Enabled!");
		getCommands();
		loadConfig();
	}
	
	@Override
	public void onDisable(){
	System.out.println("[SpawnManager] Plugin Disabled!");	
	}
	
	private void getCommands(){
		getCommand("SM").setExecutor(new SMCmd(this));
		getCommand("setworldspawn").setExecutor(new setworldspawnCmd(this));
		System.out.println("[SpawnManager] Commands loaded!");
	}
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		PREFIX = getConfig().getString("SpawnManager.Prefix");
	}
}
