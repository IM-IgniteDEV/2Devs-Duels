package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.repository.DuelPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

@RequiredArgsConstructor
public class BlockDestroyListener implements Listener {
    
    private final DuelPlayerRepository duelPlayerRepository;
    
    @EventHandler
    public void onBlockDestroy(BlockBreakEvent event) {
        
        Player player = event.getPlayer();
        DuelPlayer duelPlayerByUUID = duelPlayerRepository.findDuelPlayerByUUID(player.getUniqueId());
        
        Block block = event.getBlock();
        Arena activeArena = duelPlayerByUUID.getActiveArena();
        
        if (!activeArena.getArenaProperties().isAllowDestroy()) {
            event.setCancelled(true);
            return;
        }
        
        List<Material> destroyAllowList = activeArena.getArenaProperties().getDestroyAllowList();
        
        if (!destroyAllowList.isEmpty()) {
            if (!destroyAllowList.contains(block.getType())) {
                event.setCancelled(true);
                return;
            }
        }
        
        activeArena.addBlock(block.getLocation(), block.getType());
    }
    
}
