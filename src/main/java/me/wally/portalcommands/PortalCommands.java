package me.wally.portalcommands;

import me.wally.portalcommands.Commands.ReloadCommand;
import me.wally.portalcommands.Events.PortalUseEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PortalCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        getCommand("portalcommands").setExecutor(new ReloadCommand(this));

        this.getServer().getPluginManager().registerEvents(new PortalUseEvent(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
