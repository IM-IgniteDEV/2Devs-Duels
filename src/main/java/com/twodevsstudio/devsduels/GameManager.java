package com.twodevsstudio.devsduels;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.base.Team;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class GameManager {
    
    private final Map<Arena, List<Team>> activeGames = new HashMap<>();
    
    public void startDuel(Arena arena, List<Team> team, int maxPlayers) {
        
        if (isStarted(arena)) {
            return;
        }
        
        arena.setMaxPlayers(maxPlayers);
        
        activeGames.put(arena, team);
    }
    
    public boolean isStarted(Arena arena) {
        
        return activeGames.containsKey(arena);
    }
    
    public void stopDuel(Arena arena) {
        
        activeGames.remove(arena);
    }
    
    @Nullable
    public Arena getArenaByPlayer(DuelPlayer duelPlayer) {
        
        for (Map.Entry<Arena, List<Team>> arenaListEntry : activeGames.entrySet()) {
            List<Team> teams = arenaListEntry.getValue();
            
            for (Team team : teams) {
                if (team.getPlayers().contains(duelPlayer)) {
                    return arenaListEntry.getKey();
                }
            }
        }
        return null;
    }
    
    public List<Team> getTeamsByArena(Arena arena) {
        
        return activeGames.get(arena);
    }
    
    public int getPlayersInGame(Arena arena) {
        
        int players = 0;
        
        List<Team> teams = activeGames.get(arena);
        
        for (Team team : teams) {
            players = players + team.getPlayers().size();
        }
        
        return players;
    }
    
}
