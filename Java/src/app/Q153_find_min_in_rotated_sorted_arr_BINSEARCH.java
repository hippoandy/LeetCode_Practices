package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
// Memory Usage: 37.7 MB, less than 97.17% of Java online submissions for Find Minimum in Rotated Sorted Array.
class Q153_find_min_in_rotated_sorted_arr_BINSEARCH
{
    public int findMin(int[] nums)
    {
        if( nums == null ) throw null;
        if( nums.length == 0 ) throw null;
        
        int n = nums.length;
        int l = 0, r = n - 1;
        // corner case: sorted array
        if( nums[ r ] > nums[ l ] ) return nums[ l ];
        
        while( l < r )
        {
            int m = l + (r - l) / 2;
            if( nums[ r ] > nums[ m ] )
                r = m;
            else
                l = m + 1;
        }
        return nums[ r ];
    }
}