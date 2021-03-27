package com.twodevsstudio.devsduels.base;

import lombok.Data;

import java.util.UUID;

@Data
public class DuelPlayer {
    
    private final UUID uuid;
    private Arena activeArena;
    
}
