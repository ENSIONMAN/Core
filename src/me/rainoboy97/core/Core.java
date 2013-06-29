package me.rainoboy97.core;

import static org.bukkit.ChatColor.*;
import me.rainoboy97.core.utils.CoreLog;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
	
	public static Core core;
	
	public void onDisable() {
		
	}
	
	public void onEnable() {
		Core.core = this;
		
		CoreLog.logWithColor(GREEN + "Successfully enabled!");
	}
	
	public static Core get() {
		return core;
	}
}