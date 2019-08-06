package app;

// Runtime: 1 ms, faster than 98.58% of Java online submissions for Trapping Rain Water.
// Memory Usage: 36 MB, less than 100.00% of Java online submissions for Trapping Rain Water.
class Q42_trapping_rain_water_BF_DP
{
    // dynamic programming
    public int trap(int[] height)
    {
        if( height == null ) return 0;
        int n = height.length;
        if( n == 0 ) return 0;
        
        int[] max_left = new int[ n ];
        int[] max_right = new int[ n ];
        
        // find the max left for each element
        max_left[ 0 ] = height[ 0 ];
        for( int i = 1; i < n; i++ )
            max_left[ i ] = Math.max( max_left[ i-1 ], height[ i ] );
        
        // find the max right for each element
        max_right[ n-1 ] = height[ n-1 ];
        for( int i = n-2; i >= 0; i-- )
            max_right[ i ] = Math.max( max_right[ i+1 ], height[ i ] );
        
        int ans = 0;
        // get the result
        for( int i = 1; i < n; i++ )
            ans += Math.min( max_left[ i ], max_right[ i ] ) - height[ i ];
        return ans;
    }
    
    // // brute-force
    // public int trap(int[] height)
    // {
    //     int ans = 0;
    //     for( int i = 0; i < height.length; i++ )
    //     {
    //         int max_left = 0, max_right = 0;
    //         for( int j = i; j >= 0; j-- )
    //             max_left = Math.max( max_left, height[ j ] );
    //         for( int j = i; j < height.length; j++ )
    //             max_right = Math.max( max_right, height[ j ] );
    //         ans += Math.min( max_left, max_right ) - height[ i ];
    //     }
    //     return ans;
    // }
}