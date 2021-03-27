package com.twodevsstudio.devsduels.event;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.Team;
import lombok.EqualsAndHashCode;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@EqualsAndHashCode( callSuper = true )
public class DuelStartEvent extends DuelEvent {
    
    private static final HandlerList handlerList = new HandlerList();
    
    public DuelStartEvent(Arena arena, List<Team> teams) {
        
        super(arena, teams);
    }
    
    @Override
    public @NotNull HandlerList getHandlers() {
        
        return handlerList;
    }
}
