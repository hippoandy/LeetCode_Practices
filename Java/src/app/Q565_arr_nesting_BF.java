package app;

import java.util.*;

// Time limit exceeded!!
class Q565_arr_nesting_BF
{
    // brute-force
    int max = 0;

    public int arrayNesting(int[] nums)
    {
        if( nums == null || nums.length == 0 ) return 0;

        for( int i = 0; i < nums.length; i++ )
            helper( nums, i, new HashSet<Integer>() );
        return max;
    }
    
    private void helper( int[] nums, int idx, Set<Integer> set )
    {
        if( !set.add( nums[ idx ] ) )
        {
            max = (set.size() > max) ? set.size() : max;
            return;
        }
        else
            helper( nums, nums[ idx ], set );
    }
}