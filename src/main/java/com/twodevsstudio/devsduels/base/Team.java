package com.twodevsstudio.devsduels.base;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bukkit.Color;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Data
@RequiredArgsConstructor
public class Team {
    
    private final int size;
    private final Color color;
    private final Set<DuelPlayer> players = new HashSet<>(size);
    
    public Team(int size) {
        
        this.size = size;
        this.color = Color.fromRGB(ThreadLocalRandom.current().nextInt());
    }
    
    public void addPlayer(DuelPlayer duelPlayer) {
        
        players.add(duelPlayer);
    }
    
    public void removePlayer(DuelPlayer duelPlayer) {
        
        players.remove(duelPlayer);
    }
    
    public boolean isInTeam(DuelPlayer duelPlayer) {
        
        return players.contains(duelPlayer);
    }
    
    public boolean hasCapacity() {
        
        return players.size() < size;
    }
}
