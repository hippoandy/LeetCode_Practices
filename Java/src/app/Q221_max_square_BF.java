package app;

// Runtime: 8 ms, faster than 11.08% of Java online submissions for Maximal Square.
// Memory Usage: 40.5 MB, less than 100.00% of Java online submissions for Maximal Square.

// Time complexity: O((mn)^2). In worst case, we need to traverse the complete matrix for every 1.
// Space complexity: O(1). No extra space is used.
class Q221_max_square_BF
{
    // brute-force
    public int maximalSquare(char[][] matrix)
    {
        if( matrix == null ) return 0;
        int m = matrix.length;
        if( m == 0 ) return 0;
        int n = matrix[ 0 ].length;
        if( n == 0 ) return 0;
        
        int max = 0;
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
            {
                // if cur is '1', start traverse diagonally
                if( matrix[ i ][ j ] == '1' )
                {
                    int len = 1;
                    boolean flag = true;
                    while( (i + len) < m && (j + len) < n && flag )
                    {
                        // check the next row
                        // traverse: m(1, 0) -> m(1, 1)
                        for( int k = j; k <= (j + len); k++ )
                            if( matrix[ i + len ][ k ] == '0' )
                            {
                                flag = false;
                                break;
                            }
                        // check the next column
                        // traverse: m(0, 1) -> m(1, 1)
                        for( int k = i; k <= (i + len); k++ )
                            if( matrix[ k ][ j + len ] == '0' )
                            {
                                flag = false;
                                break;
                            }
                        if( flag ) len++;
                    }
                    max = Math.max( max, len );
                }
            }
        // the question require the area of the square
        return max * max;
    }
}