package com.twodevsstudio.devsduels;

import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Duels extends JavaPlugin {
    
    @Override
    public void onEnable() {
    
        BaseConfiguration baseConfiguration = new BaseConfiguration();
        FileConfiguration config = getConfig();
        
        baseConfiguration.initialize(config);
    }
    
    @Override
    public void onDisable() {
    
    }
}
