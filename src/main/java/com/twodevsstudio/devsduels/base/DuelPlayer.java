package com.twodevsstudio.devsduels.base;

import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@Data
public class DuelPlayer {
    
    @NotNull
    private final UUID uuid;
    @Nullable
    private Arena activeArena;
    
    private transient Player player;
    
    public Player getPlayer() {
        
        if (player == null) {
            player = Bukkit.getPlayer(uuid);
        }
        
        return player;
    }
    
}
