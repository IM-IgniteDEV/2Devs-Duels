package com.twodevsstudio.devsduels.base;

import lombok.Data;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Arena {
    
    private final String name;
    private final ItemStack icon;
    private final int timeLimit;
    private final ArenaProperties arenaProperties;
    
    private final Map<Integer, ItemStack> startingItems;
    private final List<ArenaLocation> spawningLocations;
    private final List<PotionEffect> potionEffects;
    
    private final Map<Location, Material> editedBlocks = new HashMap<>();
    
    public void addBlock(Location location, Material material){
        editedBlocks.putIfAbsent(location, material);
    }
    
    public void revertBlocks(){
        editedBlocks.forEach((location, material) -> {
            World world = location.getWorld();
            
            world.getBlockAt(location).setType(material);
        });
        
        editedBlocks.clear();
    }
    
}
