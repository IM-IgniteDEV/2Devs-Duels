package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.event.DuelEndEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DuelEndListener implements Listener {
    
    @EventHandler
    public void onDuelEnd(DuelEndEvent event) {
        
        event.getArena().revertBlocks();
    }
    
}
