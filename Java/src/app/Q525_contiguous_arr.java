// ref. https://leetcode.com/problems/contiguous-array/discuss/99646/Easy-Java-O(n)-Solution-PreSum-%2B-HashMap

package app;

import java.util.*;

// Runtime: 29 ms, faster than 58.60% of Java online submissions for Contiguous Array.
// Memory Usage: 50.6 MB, less than 100.00% of Java online submissions for Contiguous Array.
class Q525_contiguous_arr
{
    public int findMaxLength(int[] nums)
    {
        if( nums == null )     return 0;
        if( nums.length == 0 || nums.length == 1 ) return 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // starting point: count = 0, idx = -1
        // to handle the case where entire array has equal number of 0s and 1s
        /* max(i) - map[0] = N
         * => N - 1 - map[ 0 ] = N
         * => map[ 0 ] = -1
         */
        map.put( 0, -1 );
        
        int max_len = 0, count = 0;
        for( int i = 0; i < nums.length; i++ )
        {
            // every count == 0, we found the seq with same num of 1 and 0
            count = count + (nums[ i ] == 1 ? 1 : -1);
            if( map.containsKey( count ) )
                max_len = Math.max( max_len, i - map.get( count ) );
            else
                map.put( count, i );
        }
        return max_len;
    }
}