package app;

// Runtime: 27 ms, faster than 19.28% of Java online submissions for Coin Change.
// Memory Usage: 36.1 MB, less than 97.18% of Java online submissions for Coin Change.

/*
 * Time complexity: O(S∗n). where S is the amount, n is denomination count.
 * In the worst case the recursive tree of the algorithm has height of S and
 * the algorithm solves only S subproblems because it caches precalculated solutions in a table.
 * Each subproblem is computed with nn iterations, one by coin denomination. Therefore there is O(S∗n) time complexity.
 */

// Transition function: F(S) = min F(S - c_i) + 1, where i from 0 to n - 1
class Q322_coin_change_DP_TOP_DOWN
{
    public int coinChange(int[] coins, int amount)
    {
        if( amount < 1 ) return 0;
        return helper( coins, amount, new int[ amount ] );
    }
    
    public int helper( int[] coins, int amount, int[] dp )
    {
        // prevent from more recursive calls!!
        if( amount < 0 ) return -1;
        if( amount == 0 ) return 0;
        if( dp[ amount - 1 ] != 0 ) return dp[ amount - 1 ];
        
        int min = Integer.MAX_VALUE;
        for( int c: coins )
        {
            int res = helper( coins, amount - c, dp );
            if( res >= 0 && res < min )
                min = 1 + res;
        }
        dp[ amount - 1 ] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[ amount - 1 ];
    }
}