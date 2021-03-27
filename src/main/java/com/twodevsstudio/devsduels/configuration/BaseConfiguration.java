package com.twodevsstudio.devsduels.configuration;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.ArenaLocation;
import com.twodevsstudio.devsduels.base.ArenaProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BaseConfiguration {
    
    private List<Arena> arenaList;
    
    public void initialize(FileConfiguration fileConfiguration) {
        
        
        loadArenas(fileConfiguration);
    }
    
    
    private void loadArenas(FileConfiguration configuration) {
        
        ConfigurationSection arenaSection = configuration.getConfigurationSection("arenas");
        
        Validate.notNull(arenaSection, "Arena section is null!");
        
        for (String key : arenaSection.getKeys(false)) {
            
            String arenaName = arenaSection.getString(key + ".name");
            ItemStack arenaIcon = arenaSection.getItemStack(key + ".icon");
            int arenaTimeLimit = arenaSection.getInt(key + ".time-limit");
            
            boolean friendlyDamage = arenaSection.getBoolean(key + ".properties.friendly-damage");
            boolean allowDestroy = arenaSection.getBoolean(key + ".properties.allow-destroy");
            boolean dropEquipmentOnDeath = arenaSection.getBoolean(key + ".properties.drop-equipment-on-death");
            boolean dropEquipmentToInventory = arenaSection.getBoolean(key + ".properties.drop-equipment-to-inventory");
            List<Material> destroyAllowList = new ArrayList<>();
            
            arenaSection.getStringList(key + ".properties.destroy-allowlist")
                    .forEach(material -> destroyAllowList.add(Material.matchMaterial(material)));
            
            Map<Integer, ItemStack> startingItems = getArenaStartingItems(arenaSection, key);
            List<ArenaLocation> spawningLocations = getArenaSpawningLocation(arenaSection, key);
            List<PotionEffect> startingEffects = getArenaPotionEffects(arenaSection, key);
            
            ArenaProperties arenaProperties = new ArenaProperties(friendlyDamage, allowDestroy, dropEquipmentOnDeath,
                    dropEquipmentToInventory, destroyAllowList
            );
            
            arenaList.add(
                    new Arena(arenaName, arenaIcon, arenaTimeLimit, arenaProperties, startingItems, spawningLocations,
                            startingEffects
                    ));
        }
        
    }
    
    private List<PotionEffect> getArenaPotionEffects(ConfigurationSection arenaSection, String key) {
        
        List<PotionEffect> startingEffects = new ArrayList<>();
        
        arenaSection.getStringList(key + ".starting-equipment.starting-effects").forEach(effect -> {
            String[] split = key.split(":");
            
            PotionEffectType byName = PotionEffectType.getByName(split[0]);
            
            if (byName == null) {
                return;
            }
            
            startingEffects.add(new PotionEffect(byName, Integer.parseInt(split[2]), Integer.parseInt(split[1])));
        });
        
        return startingEffects;
    }
    
    private Map<Integer, ItemStack> getArenaStartingItems(ConfigurationSection arenaSection, String key) {
        
        Map<Integer, ItemStack> startingItems = new HashMap<>();
        ConfigurationSection startingItemsSection = arenaSection.getConfigurationSection(
                key + ".starting-equipment.starting-items");
        
        Validate.notNull(startingItemsSection, "Starting Items section is null!");
        
        for (String itemKey : startingItemsSection.getKeys(false)) {
            startingItems.put(Integer.parseInt(itemKey), startingItemsSection.getItemStack(itemKey));
        }
        
        return startingItems;
    }
    
    
    private List<ArenaLocation> getArenaSpawningLocation(ConfigurationSection arenaSection, String key) {
        
        List<ArenaLocation> spawningLocations = new ArrayList<>();
        ConfigurationSection startingLocationsSection = arenaSection.getConfigurationSection(key + ".spawning-points");
        
        Validate.notNull(startingLocationsSection, "Starting Locations section is null!");
        
        startingLocationsSection.getKeys(false).forEach(locationKey -> {
            
            String worldString = startingLocationsSection.getString(locationKey + ".world");
            double x = startingLocationsSection.getDouble(locationKey + ".x");
            double y = startingLocationsSection.getDouble(locationKey + ".y");
            double z = startingLocationsSection.getDouble(locationKey + ".z");
            String directionString = startingLocationsSection.getString(locationKey + ".direction");
            
            if (worldString == null) {
                return;
            }
            
            World world = Bukkit.getWorld(worldString);
            BlockFace blockFace = BlockFace.valueOf(directionString);
            
            spawningLocations.add(new ArenaLocation(world, x, y, z, blockFace));
        });
    
        return spawningLocations;
    }
    
}
