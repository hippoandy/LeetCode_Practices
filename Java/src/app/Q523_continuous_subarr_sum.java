// ref. https://leetcode.com/problems/continuous-subarray-sum/discuss/143224/C%3A-Three-Solutions.-Easy-to-understand.

package app;

import java.util.*;

// Fact: (a+(n*x))%x is same as (a%x), Remainder Therom
class Q523_continuous_subarr_sum
{
    // logic improved
    // // Runtime: 33 ms, faster than 11.28% of Java online submissions for Continuous Subarray Sum.
    // // Memory Usage: 39.2 MB, less than 97.84% of Java online submissions for Continuous Subarray Sum.
    // public boolean checkSubarraySum(int[] nums, int k)
    // {
    //     if( nums == null ) return false;
    //     if( nums.length == 0 ) return false;
        
    //     int[] runningSum = new int[ nums.length ];
    //     runningSum [ 0 ] = nums[ 0 ];
    //     for( int i = 1; i < nums.length; i++ )
    //         runningSum[ i ] = runningSum[ i-1 ] + nums[ i ];

    //     // runningSum[ j ]-runningSum[ i ] is the sum of (nums[j-1]....nums[i]) and its length is always greater than 2
    //     // To determine the sum of elements from the ith index to the jth index, we use: runningSum[j]−runningSum[i]+nums[i].
    //     for( int i = 0; i < nums.length - 1; i++ )
    //         for( int j = i+1; j < nums.length; j++ )
    //         {
    //             int subArrSum = runningSum[ j ] - runningSum[ i ] + nums[ i ];
    //             if( subArrSum == k || (k != 0 && subArrSum % k == 0) ) return true;
    //         }
    //     return false;
    // }

    // improve space complexity
    // Runtime: 3 ms, faster than 53.31% of Java online submissions for Continuous Subarray Sum.
    // Memory Usage: 39.9 MB, less than 92.81% of Java online submissions for Continuous Subarray Sum.
    public boolean checkSubarraySum(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // just to prevent a test case: [0,0], k = 0
        map.put( 0, -1 );
        int runningSum = 0;
        for( int i = 0; i < nums.length; i++ )
        {
            runningSum += nums[ i ];
            // just to prevent tricky test cases
            if( k != 0 ) runningSum %= k;
            if( map.containsKey( runningSum ) )
            {
                if( i - map.get( runningSum ) > 1 ) // at least len = 2
                    return true;
            }
            else
                map.put( runningSum, i );
        }
        return false;
    }

    // public boolean checkSubarraySum(int[] nums, int k)
    // {
    //     if( nums == null ) return false;
    //     if( nums.length == 0 ) return false;
        
    //     int[] runningSum = new int[ nums.length ];
    //     runningSum [ 0 ] = nums[ 0 ];
    //     for( int i = 1; i <= nums.length; i++ )
    //         runningSum[ i ] = runningSum[ i-1 ] + nums[ i ];

    //     // runningSum[ j ]-runningSum[ i ] is the sum of (nums[j-1]....nums[i]) and its length is always greater than 2
    //     // To determine the sum of elements from the ith index to the jth index, we use: runningSum[j]−runningSum[i]+nums[i].
    //     for( int i = 0; i < nums.length - 1; i++ )
    //         for( int j = i+1; j < nums.length; j++ )
    //         {
    //             int subArrSum = runningSum[ j ] - runningSum[ i ] + nums[ i ];
    //             if( k == 0 || (k != 0 && subArrSum % k == 0) ) return true;
    //         }
    //     return false;
    // }
}