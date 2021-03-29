package com.twodevsstudio.devsduels.inventory;

import com.twodevsstudio.devsduels.util.BaseUtil;
import lombok.Builder;
import lombok.Singular;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@Builder
public class Item {
    
    private final String name;
    @Singular( "addLore" )
    private final List<String> lore;
    private final Material type;
    
    public ItemStack getItemStack() {
        
        ItemStack itemStack = new ItemStack(type);
        
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(BaseUtil.colorComponent(name));
        itemStack.setItemMeta(itemMeta);
        
        itemStack.addItemFlags(ItemFlag.values());
        itemStack.lore(BaseUtil.colorComponent(lore));
        
        return itemStack;
    }
}
