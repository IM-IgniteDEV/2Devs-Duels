package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import com.twodevsstudio.devsduels.configuration.Properties;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public class DuelItemsInteractionsListener implements Listener {
    
    private final BaseConfiguration baseConfiguration;
    
    @EventHandler
    public void onInteractWithItem(PlayerInteractEvent event) {
        
        ItemStack item = event.getItem();
        
        if (item == null) {
            return;
        }
        
        if (checkItemStack(item)) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        
        ItemStack dropItemStack = event.getItemDrop().getItemStack();
        
        if (checkItemStack(dropItemStack)) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onItemClick(InventoryClickEvent event) {
        
        ItemStack dropItemStack = event.getCurrentItem();
        
        if (dropItemStack == null) {
            return;
        }
        
        if (checkItemStack(dropItemStack)) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onItemMove(InventoryMoveItemEvent event) {
        
        ItemStack item = event.getItem();
        
        if (checkItemStack(item)) {
            event.setCancelled(true);
        }
    }
    
    
    private boolean checkItemStack(ItemStack itemStack) {
        
        Properties properties = baseConfiguration.getProperties();
        
        return itemStack.isSimilar(properties.getDuelJoinItemStack().getItemStack()) ||
               itemStack.isSimilar(properties.getDuelCreateItemStack().getItemStack());
    }
    
    
}
