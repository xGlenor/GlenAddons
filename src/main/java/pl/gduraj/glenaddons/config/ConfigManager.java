package pl.gduraj.glenaddons.config;

import org.bukkit.configuration.file.FileConfiguration;
import pl.gduraj.glenaddons.GlenAddons;

import java.util.HashMap;

public class ConfigManager {

    private GlenAddons plugin;
    private HashMap<ConfigType, ConfigHandler> configs;

    public ConfigManager(){
        this.plugin = GlenAddons.getInstance();
        this.configs = new HashMap<>();
    }

    public void install(){
        configs.put(ConfigType.CONFIG, new ConfigHandler("config"));
        configs.put(ConfigType.MEESAGE, new ConfigHandler("message"));

        configs.values().forEach(ConfigHandler::createDefault);
    }

    public void reloadAll(){
        configs.values().forEach(ConfigHandler::reload);
    }

    public FileConfiguration getConfig(ConfigType type){
        return configs.get(type).getConfig();
    }


}
