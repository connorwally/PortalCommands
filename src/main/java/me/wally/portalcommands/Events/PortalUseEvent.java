package me.wally.portalcommands.Events;

import me.wally.portalcommands.PortalCommands;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PortalUseEvent implements Listener {

    private final PortalCommands plugin;

    public PortalUseEvent(PortalCommands plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEnterPortal(PlayerPortalEvent e) {
        Player player = e.getPlayer();
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            if (plugin.getConfig().getBoolean("end.enabled") == true) {
                if (plugin.getConfig().getBoolean("end.block-use") == true) {
                    e.setCancelled(true);
                }
                for (String command : plugin.getConfig().getStringList("end.commands")) {
                    player.performCommand(command);
                }
                for (String command : plugin.getConfig().getStringList("end.commands-console")) {
                    plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
                }
                for (String message : plugin.getConfig().getStringList("end.messages")) {
                    player.sendMessage(message);
                }
            }
        }
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {
            if (plugin.getConfig().getBoolean("nether.enabled") == true) {
                if (plugin.getConfig().getBoolean("nether.block-use") == true) {
                    e.setCancelled(true);
                }
                for (String command : plugin.getConfig().getStringList("nether.commands")) {
                    player.performCommand(command);
                }
                for (String command : plugin.getConfig().getStringList("nether.commands-console")) {
                    plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
                }
                for (String message : plugin.getConfig().getStringList("nether.messages")) {
                    player.sendMessage(message);
                }
            }
        }
    }


}
