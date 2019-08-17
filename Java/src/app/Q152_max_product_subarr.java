// ref. [SOLUTION - SPACE O(N)] https://leetcode.com/problems/maximum-product-subarray/discuss/48261/Share-my-DP-code-that-got-AC
// ref. [SOLUTION - SPACE O(1)] https://leetcode.com/problems/maximum-product-subarray/discuss/48330/Simple-Java-code

package app;

import java.lang.Math;

class Q152_max_product_subarr
{
    /*
     * Since its multiplication, while processing (i)th element, (i-1)th element is always included.
     * So (i)th element can assume that the (i-1)th element was included in either minimizing, maximizing (even previous to (i-1)th position),
     * or started a new max subarray at (i-1)th, making further path contiguous.
     * 
     * (i)th element has the similar choice, be part of further minimizing, maximizing or start a new subarray starting at i th location.
     */
    // Runtime: 2 ms, faster than 53.67% of Java online submissions for Maximum Product Subarray.
    // Memory Usage: 36.5 MB, less than 99.83% of Java online submissions for Maximum Product Subarray.
    // Space complexity: O(2n)
    // public int maxProduct(int[] nums)
    // {
    //     if( nums == null ) throw null;
    //     if( nums.length == 0 ) throw null;
        
    //     // record both the max and min for each stage
    //     // since neg * neg could possibly be an ans
    //     int[] max = new int[ nums.length ];
    //     int[] min = new int[ nums.length ];
    //     max[ 0 ] = min[ 0 ] = nums[ 0 ];
    //     int ans = nums[ 0 ];
    //     for( int i = 1; i < nums.length; i++ )
    //     {
    //         max[ i ] = Math.max(
    //             nums[ i ],
    //             Math.max( nums[ i ] * max[ i-1 ], nums[ i ] * min[ i-1 ] )
    //         );
    //         min[ i ] = Math.min(
    //             nums[ i ],
    //             Math.min( nums[ i ] * max[ i-1 ], nums[ i ] * min[ i-1 ] )
    //         );
    //         if( max[ i ] > ans ) ans = max[ i ];
    //     }
    //     return ans;
    // }

    // improve space complexity
    // since dp[ i ] only depends on dp[ i-1 ]
    // Runtime: 1 ms, faster than 99.20% of Java online submissions for Maximum Product Subarray.
    // Memory Usage: 40.8 MB, less than 7.04% of Java online submissions for Maximum Product Subarray.
    public int maxProduct(int[] nums)
    {
        if( nums == null ) throw null;
        if( nums.length == 0 ) throw null;
        
        // record both the max and min for each stage
        // since neg * neg could possibly be an ans
        int max = nums[ 0 ], min = nums[ 0 ];
        int ans = nums[ 0 ];
        for( int i = 1; i < nums.length; i++ )
        {
            int tmp = max; // we need the value from the previous stage 
            max = Math.max(
                nums[ i ],
                Math.max( nums[ i ] * tmp, nums[ i ] * min )
            );
            min = Math.min(
                nums[ i ],
                Math.min( nums[ i ] * tmp, nums[ i ] * min )
            );
            ans = ( max > ans ) ? max : ans;
        }
        return ans;
    }
}