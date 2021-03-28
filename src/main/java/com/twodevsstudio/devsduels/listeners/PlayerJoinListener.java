package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import com.twodevsstudio.devsduels.configuration.Properties;
import com.twodevsstudio.devsduels.util.SlotItemStack;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {
    
    private final BaseConfiguration baseConfiguration;
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        
        Properties properties = baseConfiguration.getProperties();
        Player player = event.getPlayer();
        
        if (properties.isGiveDuelItemsOnJoin()) {
            PlayerInventory inventory = player.getInventory();
            
            SlotItemStack duelJoinItemStack = properties.getDuelJoinItemStack();
            SlotItemStack duelCreateItemStack = properties.getDuelCreateItemStack();
            
            inventory.setItem(duelJoinItemStack.getSlot(), duelJoinItemStack.getItemStack());
            inventory.setItem(duelCreateItemStack.getSlot(), duelCreateItemStack.getItemStack());
        }
        
    }
    
}
