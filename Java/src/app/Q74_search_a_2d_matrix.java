package app;

class Q74_search_a_2d_matrix
{
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
    // Memory Usage: 40.6 MB, less than 14.86% of Java online submissions for Search a 2D Matrix.
    public boolean searchMatrix(int[][] matrix, int tar)
    {
        if( matrix == null ) return false;
        int m = matrix.length;
        if( m == 0 ) return false;
        int n = matrix[ 0 ].length;
        if( n == 0 ) return false;

        // binary search, treat the 2D matrix as a 1D array
        // row = idx / n and col = idx % n.
        int pivotIdx, pivot;
        int l = 0, r = m * n - 1;
        while( l <= r )
        {
            pivotIdx = l + (r - l) / 2;
            pivot = matrix[ pivotIdx / n ][ pivotIdx % n ];
            
            if( tar == pivot ) return true;
            else
            {
                if( tar < pivot )
                    r = pivotIdx - 1;
                else
                    l = pivotIdx + 1;
            }
        }
        return false;
    }

    // // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
    // // Memory Usage: 42.5 MB, less than 6.75% of Java online submissions for Search a 2D Matrix.
    // public boolean searchMatrix(int[][] matrix, int tar)
    // {
    //     if( matrix == null ) return false;
    //     int m = matrix.length;
    //     if( m == 0 ) return false;
    //     int n = matrix[ 0 ].length;
    //     if( n == 0 ) return false;

    //     for( int i = 0; i < m; i++ )
    //     {
    //         if( matrix[ i ][ 0 ] > tar || matrix[ i ][ n-1 ] < tar ) continue;

    //         for( int j = 0; j < n; j++ )
    //             if( matrix[ i ][ j ] == tar )
    //                 return true;
    //         return false;
    //     }
    //     return false;
    // }
}