package me.rainoboy97.core;

import me.rainoboy97.core.utils.CoreLog;
import me.rainoboy97.core.utils.Txt;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
	
	public static Core core;
	
	public void onDisable() {
		
	}
	
	public void onEnable() {
		Core.core = this;
		CoreLog.logWithColor(Txt.titleize("Enabling Core!"));
		
		
		
		
		CoreLog.logWithColor(Txt.titleize("Successfully enabled Core!"));
	}
	
	public static Core get() {
		return core;
	}
}