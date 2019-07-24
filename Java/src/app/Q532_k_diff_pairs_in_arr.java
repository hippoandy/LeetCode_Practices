// ref. https://leetcode.com/problems/k-diff-pairs-in-an-array/discuss/100098/Java-O(n)-solution-one-Hashmap-easy-to-understand

package app;

import java.util.*;

class Q532_k_diff_pairs_in_arr
{
    public int findPairs(int[] nums, int k)
    {
        if( nums == null )     return 0;
        if( nums.length == 0 ) return 0;
        if( k < 0 )            return 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // count occurence for each unique num
        for( int n: nums ) map.put( n, map.getOrDefault( n, 0 ) + 1 );
        
        int count = 0;
        for( Map.Entry<Integer, Integer> entry: map.entrySet() )
        {
            if( k == 0 )
            {
                // find all the dupicate num
                if( entry.getValue() >= 2 ) count++;
            }
            else
            {
                // refer to Two Sum Problem
                if( map.containsKey( entry.getKey() + k ) ) count++;
            }
        }
        
        return count;
    }
}