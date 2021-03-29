package com.twodevsstudio.devsduels;

import co.aikar.commands.PaperCommandManager;
import com.twodevsstudio.devsduels.command.DuelCommand;
import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Duels extends JavaPlugin {
    
    private final GameManager gameManager = new GameManager();
    private final BaseConfiguration baseConfiguration = new BaseConfiguration();
    
    @Override
    public void onEnable() {
        
        FileConfiguration config = getConfig();
        
        baseConfiguration.initialize(config);
        
        loadCommands(new PaperCommandManager(this), baseConfiguration);
        loadListeners(Bukkit.getPluginManager());
    }
    
    private void loadCommands(PaperCommandManager paperCommandManager, BaseConfiguration baseConfiguration) {
        
        paperCommandManager.registerCommand(new DuelCommand(baseConfiguration));
    }
    
    
    private void loadListeners(PluginManager pluginManager) {
    
    }
    
    @Override
    public void onDisable() {
    
    }
}
