package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.repository.DuelPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

@RequiredArgsConstructor
public class BlockDestroyListener implements Listener {
    
    private final DuelPlayerRepository duelPlayerRepository;
    
    @EventHandler
    public void onBlockDestroy(BlockBreakEvent event) {
        
        Player player = event.getPlayer();
        DuelPlayer duelPlayerByUUID = duelPlayerRepository.findDuelPlayerByUUID(player.getUniqueId());
        
        if (duelPlayerByUUID == null) {
            return;
        }
    
        Block block = event.getBlock();
        
        duelPlayerByUUID.getActiveArena().addBlock(block.getLocation(), block.getType());
    }
    
}
