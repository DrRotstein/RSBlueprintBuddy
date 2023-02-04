package com.drrotstein.rsbb.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.drrotstein.rsmcutils.commands.SubCommand;
import com.drrotstein.rsmcutils.commands.SubCommandList;
import com.drrotstein.rsmcutils.commands.SubCommandParent;

public class CommandBlueprint extends SubCommandParent {

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
		return new SubCommandList(new SubCommandBlueprintSave(), new SubCommandBlueprintLoad());
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
