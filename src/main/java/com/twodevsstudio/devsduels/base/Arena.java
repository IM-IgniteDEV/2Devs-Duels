package com.twodevsstudio.devsduels.base;

import lombok.Data;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

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
    
}
