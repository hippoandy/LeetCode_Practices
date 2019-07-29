package app;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Set Matrix Zeroes.
// Memory Usage: 50.2 MB, less than 5.06% of Java online submissions for Set Matrix Zeroes.
class Q73_set_matrix_zeroes
{
    public void setZeroes(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[ 0 ].length;
        
        // Since first cell for both first row and first column is the same i.e. matrix[0][0]
        // We can use an additional variable for either the first row/column.
        // For this solution we are using an additional variable for the first column
        // and using matrix[0][0] for the first row.
        boolean firstCol = false;

        // mark the first row and first col as flag
        for( int i = 0; i < m; i++ )
        {
            if( matrix[ i ][ 0 ] == 0 )
                firstCol = true;

            for( int j = 1; j < n; j++ )
            {
                if( matrix[ i ][ j ] == 0 )
                {
                    matrix[ i ][ 0 ] = 0;
                    matrix[ 0 ][ j ] = 0;
                }
            }
        }

        // change the value
        for( int i = 1; i < m; i++ )
            for( int j = 1; j < n; j++ )
            {
                if( matrix[ i ][ 0 ] == 0 || matrix[ 0 ][ j ] == 0 )
                    matrix[ i ][ j ] = 0;
            }

        // see if first row need to be 0
        if( matrix[ 0 ][ 0 ] == 0 )
            for( int j = 0; j < n; j++ )
                matrix[ 0 ][ j ] = 0;
        // see if first col need to be 0
        if( firstCol )
            for( int i = 0; i < m; i++ )
                matrix[ i ][ 0 ] = 0;
    }
}