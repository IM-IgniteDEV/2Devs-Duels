package com.twodevsstudio.devsduels.event;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.Team;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;

import java.util.List;

@Data
@EqualsAndHashCode( callSuper = true )
@RequiredArgsConstructor
public abstract class DuelEvent extends Event {
    
    protected final Arena arena;
    protected final List<Team> teams;
    
}
