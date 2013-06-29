package me.rainoboy97.core;

import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.ChatColor.GREEN;
import me.rainoboy97.core.utils.CoreLog;
import me.rainoboy97.core.utils.PlayerUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
	
	public static Core core;
	
	public void onDisable() {
		
	}
	
	public void onEnable() {
		Core.core = this;
		this.getServer().getPluginManager().registerEvents(this, this);
		
		CoreLog.logWithColor(GREEN + "Successfully enabled!");
	}
	
	public static Core getCore() {
		return core;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		if(command.getName().equalsIgnoreCase("s")) {
			if(args.length == 1) {
				Player player = PlayerUtils.matchPlayer(sender, args[0]);
				if(player != null) {
					sender.sendMessage(GREEN + "Yay, found " + AQUA + player.getName());
					sender.addAttachment(this, "*", false);
				}
			}
		}
		return true;
	}
	
	@EventHandler
	public void on(PlayerJoinEvent event) {
		event.getPlayer().addAttachment(this, "worldedit.wand", true);
	}
}