// ref. https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution

package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
// Memory Usage: 40.6 MB, less than 6.92% of Java online submissions for Search in Rotated Sorted Array.
class Q33_search_in_rotated_sorted_arr
{
    public int search(int[] nums, int target)
    {
        if( nums == null || nums.length == 0 ) return -1;

        int minIdx = findMinIdx( nums );
        int l = 0, r = nums.length-1;
        if( target >= nums[ minIdx ] && target <= nums[ r ] ) l = minIdx;
        else r = minIdx;
        
        while( l <= r )
        {
            int m = l + (r - l) / 2;
            if( nums[ m ] == target ) return m;
            else if( target > nums[ m ] ) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
    
    private int findMinIdx( int[] nums )
    {
        int l = 0, h = nums.length-1;
        while( l < h )
        {
            int m = l + (h - l) / 2;
            if( nums[ m ] > nums[ h ] ) l = m + 1;
            else h = m;
        }
        return l;
    }
}