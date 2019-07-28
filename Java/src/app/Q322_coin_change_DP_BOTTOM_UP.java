package app;

import java.util.*;

// Runtime: 9 ms, faster than 84.64% of Java online submissions for Coin Change.
// Memory Usage: 36.2 MB, less than 97.18% of Java online submissions for Coin Change.
class Q322_coin_change_DP_BOTTOM_UP
{
    // bottom-up dynamic programming
    public int coinChange(int[] coins, int amount)
    {
        if( amount < 1 ) return 0;
        
        int[] dp = new int[ amount+1 ];
        // don't put Integer.MAX_VALUE here, will overflow!
        Arrays.fill( dp, amount+1 );
        dp[ 0 ] = 0;
        for( int i = 1; i <= amount; i++ )
            for( int j = 0; j < coins.length; j++ )
                if( coins[ j ] <= i )
                {
                    dp[ i ] = Math.min( dp[ i ], dp[ i - coins[ j ] ] + 1 );
                }
        return dp[ amount ] > amount ? -1 : dp[ amount ];
    }
}