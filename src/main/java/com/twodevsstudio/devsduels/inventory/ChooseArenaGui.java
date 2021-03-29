package com.twodevsstudio.devsduels.inventory;

import com.twodevsstudio.devsduels.Duels;
import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ChooseArenaGui {
    
    private final String guiTitleFormat = "&6&lPick Arena";
    private final Duels duels;
    
    public void openGui(DuelPlayer player) {
        
        BaseGui.BaseGuiBuilder<?, ?> guiBuilder = BaseGui.builder().title(guiTitleFormat).rows(3);
        BaseConfiguration configuration = duels.getBaseConfiguration();
        
        List<Arena> freeArenas = configuration.getArenaList()
                .stream()
                .filter(arena -> !duels.getGameManager().getActiveGames().containsKey(arena))
                .collect(Collectors.toList());
        
        if (freeArenas.isEmpty()) {
            guiBuilder.rows(1)
                    .element(
                            4, Item.builder()
                                    .type(Material.BARRIER)
                                    .name("&cThere is no free arena")
                                    .addLore("&cPlease wait for other players")
                                    .addLore("&cTo finish their duels")
                                    .addLore("&cOr browse for active game")
                                    .build()
                                    .getItemStack());
        } else {
            for (int i = 0 ; i < freeArenas.size() ; i++) {
                guiBuilder.element(i, freeArenas.get(i).getIcon());
                guiBuilder.onClick(i, duelPlayer -> {
                    //TODO Select game mode gui for arena
                });
            }
        }
        
        guiBuilder.build().open(Bukkit.getPlayer(player.getUuid()));
    }
}
