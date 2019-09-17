// ref. https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space

package app;

// Runtime: 7 ms, faster than 34.68% of Java online submissions for Coin Change 2.
// Memory Usage: 36.8 MB, less than 30.23% of Java online submissions for Coin Change 2.
class Q518_coin_change_2
{
    // 0/1 knapsack problem
    // example: coins { 1, 2, 5 } amount = 5
    /*                0    1    2    3    4    5 <-- amount
     *          []    1    0    0    0    0    0
     *       [ 1 ]    1    1    1    1    1    1
     *    [ 1, 2 ]    1    1    2    2    3    3
     *  [ 1, 2, 5]    1    1    2    2    3    4
     *  (coin set)
     */
    public int change(int amount, int[] coins)
    {
        int[][] dp = new int[ coins.length + 1 ][ amount + 1 ];
        // I have empty set of coins to make up the amount of 0
        // so there is 1 way to do that, which is do nothing
        dp[ 0 ][ 0 ] = 1;
        
        for( int i = 1; i <= coins.length; i++ )
        {
            // 1 way to make up the amount of 0,
            // which is do nothing
            dp[ i ][ 0 ] = 1;
            for( int j = 1; j <= amount; j++ )
            {
                // don't use the new coin or use the new coins, (i-1) since 0-indexed
                dp[ i ][ j ] = dp[ i-1 ][ j ] + (j >= coins[ i-1 ] ? dp[ i ][ j-coins[ i-1 ] ] : 0);
            }
        }
        return dp[ coins.length ][ amount ];
    }
}