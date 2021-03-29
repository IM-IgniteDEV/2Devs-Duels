package com.twodevsstudio.devsduels.inventory;

import com.twodevsstudio.devsduels.Duels;
import com.twodevsstudio.devsduels.base.DuelPlayer;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Material;

@RequiredArgsConstructor
public class DuelMainGui {
    
    private final String guiTitleFormat = "&6&lDuels";
    private final Duels duels;
    
    public void openGui(DuelPlayer player) {
        
        BaseGui.builder()
                .title(guiTitleFormat)
                .rows(1)
                .element(
                        3, Item.builder()
                                .name("&6Create Duel")
                                .addLore("&6Click to create new Duel")
                                .type(Material.IRON_SWORD)
                                .build()
                                .getItemStack())
                .element(
                        5, Item.builder()
                                .name("&6Browse Duels")
                                .addLore("&6Click to browse duels")
                                .type(Material.IRON_SWORD)
                                .build()
                                .getItemStack())
                .onClick(3, duelPlayer -> new ChooseArenaGui(duels).openGui(duelPlayer))
                .onClick(5, duelPlayer -> {
                    //TODO Browse duels gui
                })
                .build()
                .open(Bukkit.getPlayer(player.getUuid()));
    }
}
// O O O # O # O O O