package me.wally.portalcommands.Commands;

import me.wally.portalcommands.PortalCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    public final PortalCommands plugin;

    public ReloadCommand(PortalCommands plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("portalcommands.reload")){
            if(args.length==0){
                sender.sendMessage(ChatColor.RED + "Usage: /randomblock reload");
            }
            if (args.length>0){
                if (args[0].equalsIgnoreCase("reload")){
                    sender.sendMessage(ChatColor.GREEN + "Reloaded PortalCommands!");
                    plugin.reloadConfig();
                }
            }
        }





        return true;
    }
}
