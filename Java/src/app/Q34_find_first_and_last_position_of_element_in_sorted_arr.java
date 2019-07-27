package app;

class Q34_find_first_and_last_position_of_element_in_sorted_arr
{
    public int[] searchRange(int[] nums, int target)
    {
        int[] ans = new int[]{ -1, -1 };
        if( nums == null )     return ans;
        if( nums.length == 0 ) return ans;

        int l = 0, r = nums.length - 1;
        // find left
        while( l < r )
        {
            int mid = (r + l) / 2;
            if( nums[ mid ] < target )
                l = mid + 1;
            else
                r = mid;
        }
        if( nums[ l ] != target ) return ans;
        else
            ans[ 0 ] = l;
        
        r = nums.length - 1;
        // find right
        while( l < r )
        {
            // When we use mid = (i+j)/2, the mid is rounded to the lowest integer. In other words, mid is always biased towards the left.
            int mid = (r + l) / 2 + 1;	// make mid biased to the right
            if( nums[ mid ] > target )
                r = mid - 1;
            else
                l = mid;
        }
        ans[ 1 ] = r;
        return ans;
    }
}