package me.rainoboy97.core.handlers;

import me.rainoboy97.core.Core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class CoreCmd implements CommandExecutor {

	@SuppressWarnings("unused")
	private Core plugin;

	public CoreCmd(Core plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		if (isPlayer(sender)) {
			Player player = (Player) sender;
			return onPlayerCmd(player, command, alias, args);
		} else {
			return onConsoleCmd(sender, command, alias, args);
		}
	}

	public abstract boolean onPlayerCmd(Player player, Command command, String alias, String[] args);

	public abstract boolean onConsoleCmd(CommandSender console, Command command, String alias, String[] args);

	public boolean isPlayer(CommandSender sender) {
		if (sender instanceof Player) {
			return true;
		} else {
			return false;
		}
	}

}
