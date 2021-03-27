package com.twodevsstudio.devsduels.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor( access = AccessLevel.PRIVATE )
public final class NumberUtils {
    
    public static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) {
            return false;
        }
        //if not, then just check the odds
        for (int i = 3 ; i * i <= n ; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
