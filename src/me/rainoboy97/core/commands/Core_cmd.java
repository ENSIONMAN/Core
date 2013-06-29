package me.rainoboy97.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.rainoboy97.core.Core;
import me.rainoboy97.core.handlers.CoreCmd;

public class Core_cmd extends CoreCmd {

	private final Core plugin;
	
	public Core_cmd(Core plugin) {
		super(plugin);
		this.plugin = plugin;
	}

	public boolean onPlayerCmd(Player player, Command command, String alias, String[] args) {
		return true;
	}

	public boolean onConsoleCmd(CommandSender console, Command command, String alias, String[] args) {
		return true;
	}

}
