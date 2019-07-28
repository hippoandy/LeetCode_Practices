package app;

// Runtime: 4 ms, faster than 95.31% of Java online submissions for Maximal Square.
// Memory Usage: 42.9 MB, less than 94.40% of Java online submissions for Maximal Square.

// Time complexity: O(mn).
// Space complexity: O(mn).
class Q221_max_square_DP
{
    // dynamic programming
    public int maximalSquare(char[][] matrix)
    {
        if( matrix == null ) return 0;
        int m = matrix.length;
        if( m == 0 ) return 0;
        int n = matrix[ 0 ].length;
        if( n == 0 ) return 0;
        
        int[][] dp = new int[ m+1 ][ n+1 ];
        int max = 0;
        for( int i = 1; i <= m; i++ )
            for( int j = 1; j <= n; j++ )
            {
                if( matrix[ i-1 ][ j-1 ] == '1' )
                {
                    dp[ i ][ j ] = Math.min(
                        Math.min( dp[ i-1 ][ j ], dp[ i-1 ][ j-1] ),
                        dp[ i][ j-1 ]
                    ) + 1;
                    // it's possible that the ans is not at the right-bottom corner
                    // (means the square is not there!!)
                    max = Math.max( max, dp[ i ][ j ] );
                }
                // if the cell is '0' do nothing
            }
        return max * max;
    }
    // brute-force
//     public int maximalSquare(char[][] matrix)
//     {
//         if( matrix == null ) return 0;
//         int m = matrix.length;
//         if( m == 0 ) return 0;
//         int n = matrix[ 0 ].length;
//         if( n == 0 ) return 0;
        
//         int max = 0;
//         for( int i = 0; i < m; i++ )
//             for( int j = 0; j < n; j++ )
//             {
//                 // if cur is '1', start traverse diagonally
//                 if( matrix[ i ][ j ] == '1' )
//                 {
//                     int len = 1;
//                     boolean flag = true;
//                     while( (i + len) < m && (j + len) < n && flag )
//                     {
//                         // check the next row
//                         // traverse: m(1, 0) -> m(1, 1)
//                         for( int k = j; k <= (j + len); k++ )
//                             if( matrix[ i + len ][ k ] == '0' )
//                             {
//                                 flag = false;
//                                 break;
//                             }
//                         // check the next column
//                         // traverse: m(0, 1) -> m(1, 1)
//                         for( int k = i; k <= (i + len); k++ )
//                             if( matrix[ k ][ j + len ] == '0' )
//                             {
//                                 flag = false;
//                                 break;
//                             }
//                         if( flag ) len++;
//                     }
//                     max = Math.max( max, len );
//                 }
//             }
//         // the question require the area of the square
//         return max * max;
//     }
}