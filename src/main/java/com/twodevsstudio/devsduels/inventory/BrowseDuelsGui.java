package com.twodevsstudio.devsduels.inventory;

import com.twodevsstudio.devsduels.Duels;
import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.DuelPlayer;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class BrowseDuelsGui {
    
    private final String guiTitleFormat = "&6&lBrowse Duels";
    private final Duels duels;
    
    public void openGui(DuelPlayer player) {
        
        BaseGui.BaseGuiBuilder<?, ?> guiBuilder = BaseGui.builder().title(guiTitleFormat).rows(3);
        List<Arena> arenas = new ArrayList<>(duels.getGameManager().getActiveGames().keySet());
        
        for (AtomicInteger i = new AtomicInteger() ; i.get() < arenas.size() ; i.getAndIncrement()) {
            int index = i.get();
            guiBuilder.element(index, arenas.get(index).getIcon());
            guiBuilder.onClick(index, duelPlayer -> duels.getDuelCommand()
                    .onJoinByArenaName(duelPlayer.getPlayer(), arenas.get(index).getName()));
        }
        
        guiBuilder.build().open(Bukkit.getPlayer(player.getUuid()));
        
    }
}
