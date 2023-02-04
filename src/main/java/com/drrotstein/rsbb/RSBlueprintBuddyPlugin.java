package com.drrotstein.rsbb;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.drrotstein.rsbb.commands.CommandBlueprint;

public class RSBlueprintBuddyPlugin extends JavaPlugin {
	
	private static RSBlueprintBuddyPlugin plugin;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		initCommands();
		initListeners();
		
	}
	
	private void initCommands() {
		getCommand("blueprint").setExecutor(new CommandBlueprint());
	}
	
	private void initListeners() {
		PluginManager pm = Bukkit.getPluginManager();
	}
	
	public static RSBlueprintBuddyPlugin getPlugin() {
		return plugin;
	}
	
}
