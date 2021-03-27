package com.twodevsstudio.devsduels.base;

import lombok.Data;
import org.bukkit.Material;

import java.util.List;

@Data
public class ArenaProperties {
    
    private boolean friendlyDamage;
    private boolean allowDestroy;
    private boolean dropEquipmentOnDeath;
    private boolean dropEquipmentToInventory;
    
    private List<Material> destroyAllowList;
    
}
