package com.twodevsstudio.devsduels.base;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bukkit.Color;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Data
@RequiredArgsConstructor
public class Team {
    
    private final int size;
    private final Color color;
    private final Set<UUID> players = new HashSet<>(size);
    
    public Team(int size) {
        
        this.size = size;
        color = Color.fromRGB(ThreadLocalRandom.current().nextInt());
    }
    
    public void addPlayer(UUID uuid) {
        
        players.add(uuid);
    }
    
    public void removePlayer(UUID uuid) {
        
        players.remove(uuid);
    }
    
    public boolean isInTeam(UUID uuid) {
        
        return players.contains(uuid);
    }
}
