package pl.gduraj.glenaddons;

import org.bukkit.plugin.java.JavaPlugin;
import pl.gduraj.glenaddons.config.ConfigManager;

import java.util.logging.Logger;

public final class GlenAddons extends JavaPlugin {

    private static GlenAddons instance;
    private ConfigManager configManager;


    @Override
    public void onEnable() {
        instance = this;

        this.configManager = new ConfigManager();
        this.configManager.install();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static GlenAddons getInstance() {
        return instance;
    }
}
