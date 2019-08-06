package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
// Memory Usage: 37 MB, less than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
class Q153_find_min_in_rotated_sorted_arr_BF
{
    public int findMin(int[] nums)
    {
        if( nums == null ) throw null;
        if( nums.length == 0 ) throw null;

        int min = Integer.MAX_VALUE;
        for( int n: nums )
            min = (n < min) ? n : min;
        return min;
    }
}