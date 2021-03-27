package com.twodevsstudio.devsduels.base;

import lombok.Data;
import org.bukkit.Material;

import java.util.List;

@Data
public class ArenaProperties {
    
    private final boolean friendlyDamage;
    private final boolean allowDestroy;
    private final boolean dropEquipmentOnDeath;
    private final boolean dropEquipmentToInventory;
    
    private final List<Material> destroyAllowList;
    
}
