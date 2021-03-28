package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.GameManager;
import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.base.Team;
import com.twodevsstudio.devsduels.repository.DuelPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

@RequiredArgsConstructor
public class PlayerDamageListener implements Listener {
    
    private final DuelPlayerRepository duelPlayerRepository;
    private final GameManager gameManager;
    
    @EventHandler
    public void onPlayerDamagePlayer(EntityDamageByEntityEvent event) {
        
        Entity damager = event.getDamager();
        Entity victim = event.getEntity();
        
        if (!(damager instanceof Player) || !(victim instanceof Player)) {
            return;
        }
        
        DuelPlayer duelPlayerDamager = duelPlayerRepository.findDuelPlayerByUUID(damager.getUniqueId());
        DuelPlayer duelPlayerVictim = duelPlayerRepository.findDuelPlayerByUUID(victim.getUniqueId());
        
        Arena activeArena = duelPlayerDamager.getActiveArena();
        
        if (activeArena == null) {
            return;
        }
        
        List<Team> teamsByArena = gameManager.getTeamsByArena(activeArena);
        
        if (!activeArena.getArenaProperties().isFriendlyDamage()) {
            teamsByArena.forEach(team -> {
                if (team.isInTeam(duelPlayerDamager) && team.isInTeam(duelPlayerVictim)) {
                    event.setCancelled(true);
                }
            });
        }
    }
}
