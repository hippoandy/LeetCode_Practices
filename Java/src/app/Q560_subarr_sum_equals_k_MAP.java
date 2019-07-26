package app;

import java.util.*;

// Runtime: 13 ms, faster than 94.70% of Java online submissions for Subarray Sum Equals K.
// Memory Usage: 39.4 MB, less than 89.25% of Java online submissions for Subarray Sum Equals K.
class Q560_subarr_sum_equals_k_MAP
{
    public int subarraySum(int[] nums, int k)
    {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put( 0, 1 );
        for( int i = 0; i < nums.length; i++ )
        {
            sum += nums[ i ];
            if( map.containsKey( sum - k ) ) count += map.get( sum - k );
            map.put( sum, map.getOrDefault( sum, 0 ) + 1 );
        }
        return count;
    }
}

// class Solution {
//     int ans = 0;
//     public int subarraySum(int[] nums, int k)
//     {
//         int count = 0;
//         for( int s = 0; s < nums.length; s++ )
//         {
//             int sum = 0;
//             for( int e = s; e < nums.length; e++ )
//             {
//                 sum += nums[ e ];
//                 if( sum == k ) count++;
//             }
//         }
//         return count;
//     }
// }