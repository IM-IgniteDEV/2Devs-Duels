package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.ArenaProperties;
import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import com.twodevsstudio.devsduels.repository.DuelPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@RequiredArgsConstructor
public class PlayerKillListener implements Listener {
    
    private final BaseConfiguration baseConfiguration;
    private final DuelPlayerRepository duelPlayerRepository;
    
    @EventHandler
    public void onPlayerKillOtherPlayer(PlayerDeathEvent event){
    
        Player victim = event.getEntity();
        Player killer = victim.getKiller();
        
        if(killer == null){
            return;
        }
        
        if (!baseConfiguration.getProperties().isDeathMessages()){
            event.deathMessage(null);
        }
    
        DuelPlayer duelPlayerKiller = duelPlayerRepository.findDuelPlayerByUUID(killer.getUniqueId());
        Arena activeArena = duelPlayerKiller.getActiveArena();
        
        if(activeArena == null){
            return;
        }
    
        ArenaProperties arenaProperties = activeArena.getArenaProperties();
        List<ItemStack> drops = event.getDrops();
        
        if (!arenaProperties.isDropEquipmentOnDeath()) {
            drops.clear();
        }
        
        if(arenaProperties.isDropEquipmentOnDeath() && arenaProperties.isDropEquipmentToInventory()){
            drops.forEach(itemStack -> killer.getInventory().addItem(itemStack));
            drops.clear();
        }
    }
    
}
