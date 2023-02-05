package com.drrotstein.rsbb.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.drrotstein.rsmcutils.commands.SubCommand;
import com.drrotstein.rsmcutils.commands.SubCommandList;
import com.drrotstein.rsmcutils.commands.SubCommandParent;
import com.drrotstein.rsmcutils.player.UUIDs.PlayerMap;

public class CommandBlueprint extends SubCommandParent {
	
	public static final PlayerMap<Location[]> PLAYER_SELECTIONS = new PlayerMap<>();
	

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
		return new SubCommandList(new SubCommandBlueprintSave(), new SubCommandBlueprintLoad());
	}

	@Override
	public List<String> getHelpMessage() {
		return Arrays.asList("'/blueprint' allows you to save and load schematics from the world.",
							"To load a schematic, use '/bp load <name> <x> <y> <z>' or just '/bp load <name>'. <name> is the name of the schematic.",
							"To save a schematic, you first need to select the two corner coordinates with '/bp first <x> <y> <z>' and '/bp second ...'. Then, you can use /bp save <name> to save the schematic.",
							"To prevent accidental data-overwriting, you need to use 'bp update <name>' to overwrite existing schematics.");
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
			if(!checkForArgsLengthEquals(1)) return false;
			return true;
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
