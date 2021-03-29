package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.ArenaLocation;
import com.twodevsstudio.devsduels.base.Team;
import com.twodevsstudio.devsduels.event.DuelEndEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DuelStartListener implements Listener {
    
    @EventHandler
    public void onDuelEnd(DuelEndEvent event) {
        
        List<Team> teams = event.getTeams();
        Arena arena = event.getArena();
        List<ArenaLocation> spawningLocations = arena.getSpawningLocations();
        
        AtomicReference<Integer> index = new AtomicReference<>(0);
        
        teams.forEach(team -> team.getPlayers().forEach(duelPlayer -> {
            duelPlayer.setActiveArena(arena);
            ArenaLocation arenaLocation = spawningLocations.get(index.get());
            
            Player player = duelPlayer.getPlayer();
            
            Location location = new Location(arenaLocation.getWorld(), arenaLocation.getX(), arenaLocation.getY(),
                    arenaLocation.getZ()
            );
            
            location.setDirection(arenaLocation.getBlockFace().getDirection());
            player.teleport(location);
            
            index.set(index.get() + 1);
        }));
    }
}
