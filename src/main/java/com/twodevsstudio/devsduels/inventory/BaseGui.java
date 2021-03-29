package com.twodevsstudio.devsduels.inventory;

import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.util.BaseUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Consumer;

@Getter
@SuperBuilder
public class BaseGui implements InventoryHolder {
    
    protected final String title;
    @Builder.Default
    protected int rows = 1;
    @Singular
    protected Map<Integer, ItemStack> elements;
    @Singular( "onClick" )
    protected Map<Integer, Consumer<DuelPlayer>> actions;
    
    @Override
    public @NotNull Inventory getInventory() {
        
        Inventory inventory = Bukkit.createInventory(this, rows * 9, BaseUtil.colorComponent(title));
        
        elements.forEach(inventory::setItem);
        return inventory;
    }
    
    public void open(Player player) {
        
        if (player == null) {
            return;
        }
        
        player.openInventory(getInventory());
    }
}
