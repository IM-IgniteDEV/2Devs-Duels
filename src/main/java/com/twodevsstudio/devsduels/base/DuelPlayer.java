package com.twodevsstudio.devsduels.base;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@Data
public class DuelPlayer {
    
    @NotNull
    private final UUID uuid;
    @Nullable
    private Arena activeArena;
    
}
