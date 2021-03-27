package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.repository.DuelPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

@RequiredArgsConstructor
public class BlockPlaceListener implements Listener {
    
    private final DuelPlayerRepository duelPlayerRepository;
    
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        
        Player player = event.getPlayer();
        DuelPlayer duelPlayerByUUID = duelPlayerRepository.findDuelPlayerByUUID(player.getUniqueId());
        
        if (duelPlayerByUUID == null) {
            return;
        }
        
        BlockState blockReplacedState = event.getBlockReplacedState();
        
        duelPlayerByUUID.getActiveArena().addBlock(blockReplacedState.getLocation(), blockReplacedState.getType());
    }
    
}
