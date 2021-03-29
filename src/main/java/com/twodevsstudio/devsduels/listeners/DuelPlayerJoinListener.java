package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.GameManager;
import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.event.DuelPlayerJoinEvent;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@RequiredArgsConstructor
public class DuelPlayerJoinListener implements Listener {
    
    private final GameManager gameManager;
    
    @EventHandler
    public void onPlayerJoinDuel(DuelPlayerJoinEvent event) {
    
        Arena arena = event.getArena();

    
        if (gameManager.getPlayersInGame(arena) == arena.getMaxPlayers()) {
            
            // start game
            
        }
    
    }
}
