package com.twodevsstudio.devsduels.util;

import com.twodevsstudio.devsduels.base.Arena;
import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.base.Team;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor( access = AccessLevel.PRIVATE )
public final class GameUtils {
    
    public static List<Integer> getPossibleTeamSizes(Arena arena) {
        
        List<Integer> possibleGameModes = new ArrayList<>();
        possibleGameModes.add(1);
        int arenaCapacity = arena.getSpawningLocations().size();
        if (NumberUtils.isPrime(arenaCapacity)) {
            return possibleGameModes;
        }
        
        for (int i = 2 ; i <= arenaCapacity / 2 ; i++) {
            if (arenaCapacity % i == 0) {
                possibleGameModes.add(i);
            }
        }
        
        return possibleGameModes;
    }
    
    public static List<Team> prepareTeams(Arena arena, int teamSize) {
        
        List<Integer> possibleTeamSizes = getPossibleTeamSizes(arena);
        if (!possibleTeamSizes.contains(teamSize)) {
            return prepareTeams(arena, 1);
        }
        
        List<Team> teams = new ArrayList<>();
        
        int capacity = arena.getSpawningLocations().size();
        int numberOfTeams = capacity / teamSize;
        
        for (int i = 0 ; i < numberOfTeams ; i++) {
            teams.add(new Team(teamSize));
        }
        
        return teams;
    }
    
    public static void addPlayerToTeam(List<Team> teams, DuelPlayer duelPlayer) {
        
        Team lowestCountTeam = teams.get(0);
        
        for (Team team : teams) {
            if (team.getPlayers().size() < lowestCountTeam.getPlayers().size()) {
                lowestCountTeam = team;
            }
        }
        
        lowestCountTeam.addPlayer(duelPlayer);
    }
    
}
