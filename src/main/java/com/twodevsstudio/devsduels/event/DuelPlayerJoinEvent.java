package com.twodevsstudio.devsduels.event;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.Team;
import lombok.EqualsAndHashCode;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@EqualsAndHashCode( callSuper = true )
public class DuelPlayerJoinEvent extends DuelEvent {
    
    private static final HandlerList handlerList = new HandlerList();
    
    private final Team joinedTeam;
    
    public DuelPlayerJoinEvent(Arena arena, List<Team> teams, Team joinedTeam) {
        super(arena, teams);
        this.joinedTeam = joinedTeam;
    }
    
    @Override
    public @NotNull HandlerList getHandlers() {
        
        return handlerList;
    }
    
}
