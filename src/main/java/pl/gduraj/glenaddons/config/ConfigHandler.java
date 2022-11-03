package pl.gduraj.glenaddons.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;
import pl.gduraj.glenaddons.GlenAddons;

import java.io.File;
import java.io.IOException;

public class ConfigHandler {

    private GlenAddons plugin;
    private String name;
    private File file;
    private FileConfiguration config;

    public ConfigHandler(String name){
        this.plugin = GlenAddons.getInstance();
        this.name = name + ".yml";
        this.file = new File(plugin.getDataFolder(), this.name);
        this.config = new YamlConfiguration();
    }

    public void createDefault(){
        if(!file.exists()){
            plugin.saveResource(name, false);
        }

        try{
            config.load(file);
        } catch ( InvalidConfigurationException | IOException e){
            e.printStackTrace();
            plugin.getLogger().warning("Error create file: " + name);
        }
    }

    public void saveConfig(){
        if(config == null || file == null){
            return;
        }
        try {
            getConfig().save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void reload(){
        config = YamlConfiguration.loadConfiguration(file);
    }


    public File getFile() {
        return file;
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
