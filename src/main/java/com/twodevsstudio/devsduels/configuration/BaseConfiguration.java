package com.twodevsstudio.devsduels.configuration;

import com.twodevsstudio.devsduels.base.Arena;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

@Getter
@Setter
public class BaseConfiguration {
    
    private List<Arena> arenaList;

    public void initialize(FileConfiguration fileConfiguration){
        
    
        loadArenas(fileConfiguration);
    }
    
    
    private void loadArenas(FileConfiguration fileConfiguration){
    
    
    
    }

}
