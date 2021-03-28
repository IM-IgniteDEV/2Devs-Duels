package com.twodevsstudio.devsduels.repository;

import com.twodevsstudio.devsduels.base.DuelPlayer;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DuelPlayerRepository {
    
    @Getter
    private final Map<UUID, DuelPlayer> playerCache = new ConcurrentHashMap<>();
    
    @NotNull
    public DuelPlayer findDuelPlayerByUUID(UUID uuid) {
        
        DuelPlayer duelPlayer = playerCache.get(uuid);
        
        if (duelPlayer == null) {
            duelPlayer = new DuelPlayer(uuid);
            addToCache(duelPlayer);
        }
        
        return duelPlayer;
    }
    
    public void addToCache(DuelPlayer duelPlayer) {
        
        playerCache.put(duelPlayer.getUuid(), duelPlayer);
    }
    
}
