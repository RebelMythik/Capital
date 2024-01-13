package me.rebelmythik.capital;

import co.aikar.commands.PaperCommandManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Capital extends JavaPlugin {

    private PaperCommandManager commandManager;

    private static Economy economy = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Please install Vault to use this plugin.", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        //

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands() {
        PaperCommandManager commandManager = new PaperCommandManager(this);

        // Register Commmands
        



    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }


    public PaperCommandManager getCommandManager() {
        return this.commandManager;
    }
    public Economy getEconomy() {
        return economy;
    }

}
