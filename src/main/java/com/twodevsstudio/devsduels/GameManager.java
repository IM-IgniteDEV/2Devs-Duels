package com.twodevsstudio.devsduels;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.Team;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class GameManager {
    
    private final Map<Arena, List<Team>> activeGames = new HashMap<>();
    
    public void startDuel(Arena arena, List<Team> team) {
        
        if (isStarted(arena)) {
            return;
        }
        
        activeGames.put(arena, team);
    }
    
    public boolean isStarted(Arena arena) {
        
        return activeGames.containsKey(arena);
    }
    
    public void stopDuel(Arena arena) {
        
        activeGames.remove(arena);
    }
}
