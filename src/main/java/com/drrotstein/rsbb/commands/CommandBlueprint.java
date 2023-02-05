package com.drrotstein.rsbb.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.drrotstein.rsmcutils.commands.SubCommand;
import com.drrotstein.rsmcutils.commands.SubCommandList;
import com.drrotstein.rsmcutils.commands.SubCommandParent;
import com.drrotstein.rsmcutils.player.UUIDs.PlayerMap;
import com.drrotstein.rsmcutils.world.LocationUtils;

public class CommandBlueprint extends SubCommandParent {
	
	public static final PlayerMap<Location[]> PLAYER_SELECTIONS = new PlayerMap<>();
	public static final Location[] CONSOLE_SELECTIONS = new Location[2];
	

	@Override
	public boolean command(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("§cUse '/blueprint help' for a detailed instruction on how to use this command!");
		return false;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
		return null;
	}

	@Override
	public SubCommandList getSubCommands() {
		return new SubCommandList(new SubCommandBlueprintSave(), new SubCommandBlueprintLoad(), new SubCommandBlueprintFirst(),
									new SubCommandBlueprintSecond(), new SubCommandBlueprintUpdate());
	}

	@Override
	public List<String> getHelpMessage() {
		return Arrays.asList("'/blueprint' allows you to save and load schematics from the world.",
							"To load a schematic, use '/bp load <name> <x> <y> <z>' or just '/bp load <name>'. <name> is the name of the schematic.",
							"To save a schematic, you first need to select the two corner coordinates with '/bp first <x> <y> <z>' and '/bp second ...'. Then, you can use /bp save <name> to save the schematic.",
							"To prevent accidental data-overwriting, you need to use 'bp update <name>' to overwrite existing schematics.");
	}
	
	private static boolean select(CommandSender sender, SubCommand sub, String[] args, boolean first) {
		if(!sub.checkForArgsLengthEquals(0, 3)) return false;
		Player player = sender instanceof Player ? (Player) sender : null;
		if(args.length == 0) {
			if(player == null) {
				sender.sendMessage("§cYou have to be a player in order to perform this command without arguments!");
				return false;
			}
			return select(sender, sub, new String[] {"~", "~", "~"}, first);
		}
		String locString = "";
		for(String arg : args) {
			if((arg.contains("~") || arg.contains("^")) && player == null) {
				sender.sendMessage("§cYou have to be a player in order to use relative coordinates!");
				return false;
			}
			locString += arg + " ";
		}
		locString = locString.trim();
		Location loc;
		if(player != null) loc = LocationUtils.undisplay(player, locString, " ");
		else loc = LocationUtils.undisplay(locString, " ");
		if(loc == null) {
			sender.sendMessage("§c'" + locString + "' is an invalid location!");
			return false;
		}
		loc = LocationUtils.toBlockPos(loc);
		sender.sendMessage("§a'" + LocationUtils.display(loc, " ") + "' was selected as " + (first ? "first" : "second") + " position!");
		
		//If first==true, then the second position is set to null on purpose, so that players don't forget to set a new second position if something was selected before
		if(player != null) {
			if(first) PLAYER_SELECTIONS.put(player, new Location[] {loc, null});
			else PLAYER_SELECTIONS.get(player)[1] = loc;
		} else {
			if(first) CONSOLE_SELECTIONS[0] = loc;
			CONSOLE_SELECTIONS[1] = first ? null : loc;
		}
		
		return true;
	}
	
	
	public static class SubCommandBlueprintFirst extends SubCommand {

		@Override
		public String getLabel() {
			return "first";
		}

		@Override
		public String getPermission() {
			return "rsbb.bp.select";
		}

		@Override
		public boolean command(CommandSender sender, Command command, String label, String[] args) {
			return select(sender, this, args, true);
		}

		@Override
		public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
			return sender instanceof Player ? LocationUtils.lookingAtTabCompletion((Player) sender, args) : new ArrayList<>();
		}

		@Override
		public SubCommandList getSubCommands() {
			return new SubCommandList();
		}
		
	}
	
	public static class SubCommandBlueprintSecond extends SubCommand {

		@Override
		public String getLabel() {
			return "second";
		}

		@Override
		public String getPermission() {
			return "rsbb.bp.select";
		}

		@Override
		public boolean command(CommandSender sender, Command command, String label, String[] args) {
			return select(sender, this, args, false);
		}

		@Override
		public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
			return sender instanceof Player ? LocationUtils.lookingAtTabCompletion((Player) sender, args) : new ArrayList<>();
		}

		@Override
		public SubCommandList getSubCommands() {
			return new SubCommandList();
		}
		
	}
	
	public static class SubCommandBlueprintSave extends SubCommand {

		@Override
		public String getLabel() {
			return "save";
		}

		@Override
		public String getPermission() {
			return "rsbb.bp.save";
		}

		@Override
		public boolean command(CommandSender sender, Command command, String label, String[] args) {
			return false;
		}

		@Override
		public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
			return null;
		}

		@Override
		public SubCommandList getSubCommands() {
			return null;
		}
		
	}
	
	public static class SubCommandBlueprintUpdate extends SubCommand {

		@Override
		public String getLabel() {
			return "update";
		}

		@Override
		public String getPermission() {
			return "rsbb.bp.update";
		}

		@Override
		public boolean command(CommandSender sender, Command command, String label, String[] args) {
			return false;
		}

		@Override
		public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
			return null;
		}

		@Override
		public SubCommandList getSubCommands() {
			return null;
		}
		
	}
	
	public static class SubCommandBlueprintLoad extends SubCommand {

		@Override
		public String getLabel() {
			return "load";
		}

		@Override
		public String getPermission() {
			return "rsbb.bp.load";
		}

		@Override
		public boolean command(CommandSender sender, Command command, String label, String[] args) {
			return false;
		}

		@Override
		public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
			return null;
		}

		@Override
		public SubCommandList getSubCommands() {
			return null;
		}
		
	}

}
