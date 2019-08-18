package app;

// Runtime: 4 ms, faster than 91.31% of Java online submissions for Sliding Window Maximum.
// Memory Usage: 42 MB, less than 54.69% of Java online submissions for Sliding Window Maximum.
class Q239_sliding_window_max_DP
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;
        if( n * k == 0 ) return new int[ 0 ];
        if( k == 1 ) return nums;
        
        // left[j] is a maximum element from the beginning of the block to index j
        int[] left = new int[ n ];
        left[ 0 ] = nums[ 0 ];
        // right[j] is a maximum element from the end of the block to index j
        int[] right = new int[ n ];
        right[ n-1 ] = nums[ n-1 ];
        // compute left & right array
        for( int i = 1; i < n; i++ )
        {   // from left to right
            // block start
            if( i % k == 0 ) left[ i ] = nums[ i ];
            else left[ i ] = Math.max( left[ i-1 ], nums[ i ] );
            
            // from right to left
            // block end
            int j = n - i - 1;
            if( (j + 1) % k == 0 ) right[ j ] = nums[ j ];
            else right[ j ] = Math.max( right[ j+1 ], nums[ j ] );
        }
        
        int[] output = new int[ n-k+1 ];
        int i = 0, j = k-1; // 0-indexed
        while( j < n ) output[ i ] = Math.max( right[ i++ ], left[ j++ ] );
        return output;
    }
}