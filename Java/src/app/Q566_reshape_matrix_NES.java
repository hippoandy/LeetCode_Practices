package app;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Reshape the Matrix.
// Memory Usage: 39.7 MB, less than 84.83% of Java online submissions for Reshape the Matrix.
class Q566_reshape_matrix_NES
{
    public int[][] matrixReshape(int[][] nums, int r, int c)
    {
        if( nums == null ) return nums;
        if( nums.length == 0 ) return nums;
        
        int m = nums.length, n = nums[ 0 ].length;
        if( r * c != m * n ) return nums;
        
        int[][] ans = new int[ r ][ c ];
        
        int r_idx = 0, c_idx = 0;
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
            {
                ans[ r_idx ][ c_idx ] = nums[ i ][ j ];
                c_idx++;
                if( c_idx == c )
                {
                    r_idx++;
                    c_idx = 0;
                }
            }
        return ans;
    }
}