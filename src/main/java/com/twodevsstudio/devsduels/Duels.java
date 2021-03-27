package com.twodevsstudio.devsduels;

import co.aikar.commands.PaperCommandManager;
import com.twodevsstudio.devsduels.command.DuelCommand;
import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Duels extends JavaPlugin {
    
    @Override
    public void onEnable() {
    
        BaseConfiguration baseConfiguration = new BaseConfiguration();
        FileConfiguration config = getConfig();
        
        baseConfiguration.initialize(config);
        
        loadCommands(new PaperCommandManager(this), baseConfiguration);
    }
    
    private void loadCommands(PaperCommandManager paperCommandManager, BaseConfiguration baseConfiguration){
        paperCommandManager.registerCommand(new DuelCommand(baseConfiguration));
    }
    
    @Override
    public void onDisable() {
    
    }
}
