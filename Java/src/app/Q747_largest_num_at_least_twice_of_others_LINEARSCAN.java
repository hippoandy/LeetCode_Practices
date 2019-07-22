package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Number At Least Twice of Others.
class Q747_largest_num_at_least_twice_of_others_LINEARSCAN
{
    public int dominantIndex(int[] nums)
    {
        // there is always exactly one largest element!!!
        int max_idx = 0;
        for( int i = 0; i < nums.length; i++ )
            if( nums[ i ] > nums[ max_idx ] ) max_idx = i;
        // scan through the array again; if we find some x != m with m < 2*x, we should return -1.
        for( int i = 0; i < nums.length; i++ )
            if( max_idx != i && nums[ max_idx ]/2 < nums[ i ] )
                return -1;
        return max_idx;
    }
}