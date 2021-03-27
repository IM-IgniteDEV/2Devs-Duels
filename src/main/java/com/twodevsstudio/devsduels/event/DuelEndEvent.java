package com.twodevsstudio.devsduels.event;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.Team;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter
@EqualsAndHashCode( callSuper = true )
public class DuelEndEvent extends DuelEvent {
    
    private static final HandlerList handlerList = new HandlerList();
    
    private final Team winner;
    
    public DuelEndEvent(Arena arena, List<Team> teams, Team winner) {
        
        super(arena, teams);
        this.winner = winner;
    }
    
    @Override
    public @NotNull HandlerList getHandlers() {
        
        return handlerList;
    }
}
