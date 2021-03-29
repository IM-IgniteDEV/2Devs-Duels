package com.twodevsstudio.devsduels.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.twodevsstudio.devsduels.Duels;
import com.twodevsstudio.devsduels.GameManager;
import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.base.Team;
import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import com.twodevsstudio.devsduels.repository.DuelPlayerRepository;
import com.twodevsstudio.devsduels.util.BaseUtil;
import com.twodevsstudio.devsduels.util.GameUtils;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

@SuppressWarnings( "unused" ) // aikar commands
@CommandAlias( "duel|duels" )
@CommandPermission( "duels.user" )
@RequiredArgsConstructor
public class DuelCommand extends BaseCommand {
    
    
    /*
     *
     * /duel create <arena name> <team_size> <max_players>
     *
     *
     */
    
    private final BaseConfiguration baseConfiguration;
    private final GameManager gameManager;
    private final DuelPlayerRepository duelPlayerRepository;
    private final Duels duels;
    
    @Default
    public void onHelp(Player player) {
        
        player.sendMessage(BaseUtil.colorComponent(baseConfiguration.getDuelsCommandUsage()));
    }
    
    @Subcommand( "create" )
    @Syntax( "<team_size> <max_players> <arena_name>" )
    public void onCreate(Player player, String arenaName, int teamSize, int maxPlayers) {
        
        Arena arenaByName = baseConfiguration.getArenaByName(arenaName);
        
        if (arenaByName == null) {
            onArenaList(player);
            return;
        }
        
        List<Team> teams = GameUtils.prepareTeams(arenaByName, teamSize);
        
        teams.get(0).addPlayer(duelPlayerRepository.findDuelPlayerByUUID(player.getUniqueId()));
        
        gameManager.startDuel(arenaByName, teams, maxPlayers);
    }
    
    @Subcommand( "join" )
    @Syntax( "<specify arena>" )
    public void onJoinByArenaName(Player player, String arenaName) {
        
        Arena arenaByName = baseConfiguration.getArenaByName(arenaName);
        
        if (arenaByName == null) {
            // todo message
            return;
        }
    
        DuelPlayer duelPlayer = duelPlayerRepository.findDuelPlayerByUUID(player.getUniqueId());
    
        GameUtils.addPlayerToTeam(gameManager.getTeamsByArena(arenaByName), duelPlayer);
    }
    
    @Subcommand( "join" )
    @Syntax( "<specify player to join him>" )
    public void onJoinByPlayer(Player player, String playerToJoin) {
        
        Player target = Bukkit.getPlayer(playerToJoin);
        
        if (target == null) {
            // todo message
            return;
        }
        
        DuelPlayer duelPlayerTarget = duelPlayerRepository.findDuelPlayerByUUID(target.getUniqueId());
        DuelPlayer duelPlayer = duelPlayerRepository.findDuelPlayerByUUID(player.getUniqueId());
        Arena arenaByTarget = gameManager.getArenaByPlayer(duelPlayerTarget);
        
        GameUtils.addPlayerToTeam(gameManager.getTeamsByArena(arenaByTarget), duelPlayer);
        
        // todo message
    }
    
    @Subcommand( "arenalist" )
    public void onArenaList(Player player) {
        
        StringBuilder stringBuilder = new StringBuilder("Available Arenas: ");
        
        baseConfiguration.getArenaList().forEach(arena -> stringBuilder.append(arena.getName()).append(", "));
        
        player.sendMessage(BaseUtil.colorComponent(stringBuilder.toString()));
    }
    
}
