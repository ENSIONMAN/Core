package me.rainoboy97.core;

import me.rainoboy97.core.commands.Core_cmd;
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
		
		long timeStarted = System.currentTimeMillis();
		
		CoreLog.logWithColor("<green>Enabling");
		CoreLog.logWithColor("<yellow>Registering commands");
		this.registerCommands();
		CoreLog.logWithColor("<yellow>Registering events");
		// Register events
		long timeNow = System.currentTimeMillis();
		CoreLog.logWithColor(Txt.parse("<green>Successfully enabled (<gold>" + (timeNow - timeStarted) + "ms<green>)"));
	}
	
	private void registerCommands() {
		this.getCommand("core").setExecutor(new Core_cmd(this));
	}

	public static Core get() {
		return core;
	}
}