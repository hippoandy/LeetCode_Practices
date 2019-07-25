package app;

import java.util.*;

// Runtime: 24 ms, faster than 12.15% of Java online submissions for Set Mismatch.
// Memory Usage: 40.8 MB, less than 96.09% of Java online submissions for Set Mismatch.
class Q645_set_mismatch
{
    public int[] findErrorNums(int[] nums)
    {
        if( nums == null )     return new int[0];
        if( nums.length == 0 ) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int n: nums ) map.put( n, map.getOrDefault( n, 0 ) + 1 );
        
        int dup = 0, missing = 0;
        for( int i = 1; i <= nums.length; i++ )
        {
            if( map.containsKey( i ) )
            {
                if( map.get( i ) > 1 )
                    dup = i;
            }
            else
                missing = i;
        }
        return new int[]{ dup, missing };
    }
}