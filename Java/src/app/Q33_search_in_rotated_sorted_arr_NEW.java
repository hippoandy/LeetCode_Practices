package app;

// new template of binary search
// ref. https://github.com/yuzhoujr/leetcode/issues/8

class Q33_search_in_rotated_sorted_arr_NEW
{
    public int search(int[] nums, int target)
    {
        if( nums == null || nums.length == 0 ) return -1;

        int minIdx = findMinIdx( nums );

        int l = 0, r = nums.length-1;
        if( target >= nums[ minIdx ] && target <= nums[ r ] ) l = minIdx;
        else r = minIdx;

        while( l + 1 < r )
        {
            int m = l + (r - l) / 2;
            if( nums[ m ] == target ) return m;
            if( nums[ m ] < target ) l = m;
            else                     r = m;
        }
        if( nums[ l ] == target ) return l;
        if( nums[ r ] == target ) return r;
        return -1;
    }
    
    private int findMinIdx( int[] nums )
    {
        int l = 0, r = nums.length - 1;
        while( l + 1 < r )
        {
            int m = l + (r - l) / 2;
            if( nums[ m ] > nums[ r ] ) l = m;
            else                        r = m;
        }
        // the problem requires the index to be returned
        if( nums[ l ] > nums[ r ] ) return r;
        return l;
    }
}