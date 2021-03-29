package com.twodevsstudio.devsduels;

import co.aikar.commands.PaperCommandManager;
import com.twodevsstudio.devsduels.command.DuelCommand;
import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import com.twodevsstudio.devsduels.repository.DuelPlayerRepository;
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
        DuelPlayerRepository duelPlayerRepository = new DuelPlayerRepository();
        
        baseConfiguration.initialize(config);
        
        loadCommands(new PaperCommandManager(this), baseConfiguration, duelPlayerRepository);
        loadListeners(Bukkit.getPluginManager());
    }
    
    private void loadCommands(PaperCommandManager paperCommandManager,
                              BaseConfiguration baseConfiguration,
                              DuelPlayerRepository duelPlayerRepository
    ) {
        
        paperCommandManager.registerCommand(
                new DuelCommand(baseConfiguration, gameManager, duelPlayerRepository, this));
    }
    
    
    private void loadListeners(PluginManager pluginManager) {
    
    }
    
    @Override
    public void onDisable() {
    
    }
}
