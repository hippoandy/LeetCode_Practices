package app;

import java.lang.Math;

class Q198_house_robber
{
    // improve space complexity
    // since the dp[ i ] only depends on dp[ i-1 ] and dp[ i-2 ]
    // Space complexity: O(1)
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
    // Memory Usage: 34 MB, less than 100.00% of Java online submissions for House Robber.
    public int rob(int[] nums)
    {
        if( nums.length == 0 ) return 0;
        if( nums.length == 1 ) return nums[ 0 ];
        if( nums.length == 2 ) return Math.max( nums[ 0 ], nums[ 1 ] );

        int dp_2 = nums[ 0 ];
        int dp_1 = Math.max( nums[ 0 ], nums[ 1 ] );
        int dp_0 = 0;
        
        for( int i = 2; i < nums.length; i++ )
        {
            // i - 2 since the condition:
            // if two adjacent houses were broken, alert the police.
            dp_0 = Math.max( dp_2 + nums[ i ], dp_1 );
            // shift
            dp_2 = dp_1;
            dp_1 = dp_0;
        }
        return dp_0;
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
    // Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for House Robber.
    // Space complexity: O(n)
    // public int rob(int[] nums)
    // {
    //     if( nums.length == 0 ) return 0;
    //     if( nums.length == 1 ) return nums[ 0 ];
    //     if( nums.length == 2 ) return Math.max( nums[ 0 ], nums[ 1 ] );
        
    //     int[] dp = new int[ nums.length ];
    //     dp[ 0 ] = nums[ 0 ];
    //     dp[ 1 ] = Math.max( nums[ 0 ], nums[ 1 ] );
        
    //     for( int i = 2; i < nums.length; i++ )
    //     {
    //         // i - 2 since the condition:
    //         // if two adjacent houses were broken, alert the police.
    //         dp[ i ] = Math.max( dp[ i - 2 ] + nums[ i ], dp[ i - 1 ] );
    //     }
    //     return dp[ nums.length - 1 ];
    // }
}