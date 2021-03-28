package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.event.DuelEndEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DuelStartListener implements Listener {
    
    @EventHandler
    public void onDuelEnd(DuelEndEvent event) {
        
        event.getTeams()
                .forEach(team -> team.getPlayers().forEach(duelPlayer -> duelPlayer.setActiveArena(event.getArena())));
    }
    
}
