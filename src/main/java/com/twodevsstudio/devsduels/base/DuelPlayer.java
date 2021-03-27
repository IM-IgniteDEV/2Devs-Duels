package com.twodevsstudio.devsduels.base;

import lombok.Data;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class DuelPlayer {
    
    private final UUID uuid;
    private final Map<Location, Material> editedBlocks = new HashMap<>();
    
    public void addBlock(Location location, Material material){
        editedBlocks.put(location, material);
    }
    
    public void revertBlocks(){
        editedBlocks.forEach((location, material) -> {
            World world = location.getWorld();
            
            world.getBlockAt(location).setType(material);
        });
        
        editedBlocks.clear();
    }
    
}
