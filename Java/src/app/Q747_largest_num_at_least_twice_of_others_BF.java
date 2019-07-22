package app;

import java.util.*;

// Runtime: 1 ms, faster than 32.50% of Java online submissions for Largest Number At Least Twice of Others.
class Q747_largest_num_at_least_twice_of_others_BF
{
    public int dominantIndex(int[] nums)
    {
        if( nums == null ) return -1;
        if( nums.length == 0 ) return -1;
        if( nums.length == 1 ) return 0;
        
        int[] original = nums.clone();
        Arrays.sort( nums );
        if( nums[ nums.length - 1 ] / 2 >= nums[ nums.length - 2 ] )
        {
            for( int i = 0; i < original.length; i++ )
                if( original[ i ] == nums[ nums.length - 1 ] ) return i;
        }

        return -1;
    }
}