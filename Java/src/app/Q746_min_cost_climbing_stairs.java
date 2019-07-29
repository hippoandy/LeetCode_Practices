package app;

class Q746_min_cost_climbing_stairs
{
    // Runtime: 1 ms, faster than 99.88% of Java online submissions for Min Cost Climbing Stairs.
    // Memory Usage: 41.4 MB, less than 9.68% of Java online submissions for Min Cost Climbing Stairs.
    // public int minCostClimbingStairs(int[] cost)
    // {
    //     if( cost == null ) return 0;
    //     if( cost.length == 0 ) return 0;
        
    //     int[] dp = new int[ cost.length + 1 ];
    //     dp[ 0 ] = 0; // we could start at idx 0 (use 1 steps from beginning)
    //     dp[ 1 ] = 0; // we could start at idx 1 (use 2 steps from beginning)
        
    //     for( int i = 2; i <= cost.length; i++ )
    //         dp[ i ] = Math.min(
    //             dp[ i-1 ] + cost[ i-1 ],
    //             dp[ i-2 ] + cost[ i-2 ]
    //         );
    //     return dp[ cost.length ];
    // }

    // improve space complexity
    // Runtime: 1 ms, faster than 99.88% of Java online submissions for Min Cost Climbing Stairs.
    // Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Min Cost Climbing Stairs.
    public int minCostClimbingStairs(int[] cost)
    {
        if( cost == null ) return 0;
        if( cost.length == 0 ) return 0;

        int dp_2 = 0; // we could start at idx 1 (use 2 steps from beginning) == dp[ i-2 ]
        int dp_1 = 0; // we could start at idx 0 (use 1 steps from beginning) == dp[ i-1 ]
        int dp_0 = 0; // current
        
        for( int i = 2; i <= cost.length; i++ )
        {
            dp_0 = Math.min(
                dp_1 + cost[ i-1 ],
                dp_2 + cost[ i-2 ]
            );
            dp_2 = dp_1;
            dp_1 = dp_0;
        }
        return dp_0;
    }
}