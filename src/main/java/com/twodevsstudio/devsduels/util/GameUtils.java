package com.twodevsstudio.devsduels.util;

import com.twodevsstudio.devsduels.base.Arena;
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
    
}
