package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Trapping Rain Water.
// Memory Usage: 37.9 MB, less than 91.91% of Java online submissions for Trapping Rain Water.
class Q42_trapping_rain_water_TWOPOINTER
{
    // two-pointer
    public int trap( int[] height )
    {
        if( height == null ) return 0;
        int n = height.length;
        if( n == 0 ) return 0;
        
        int ans = 0;
        int l = 0, r = n-1;
        int max_left = 0, max_right = 0;
        while( l < r )
        {
            if( height[ l ] < height[ r ] )
            {
                if( height[ l ] >= max_left )
                    max_left = height[ l ];
                else
                    ans += max_left - height[ l ];
                l++;
            }
            else
            {
                if( height[ r ] >= max_right )
                    max_right = height[ r ];
                else
                    ans += max_right - height[ r ];
                r--;
            }
        }
        return ans;
    }
}