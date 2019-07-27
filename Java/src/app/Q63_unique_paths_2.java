package app;

class Q63_unique_paths_2
{
    public int uniquePathsWithObstacles( int[][] board )
    {
        if( board == null ) return 0;
        int m = board.length;
        if( m == 0 ) return 0;
        int n = board[ 0 ].length;
        if( n == 0 ) return 0;
        
        // corner case, if the start point is block, no way to get to the end
        if( board[ 0 ][ 0 ] == 1 ) return 0;

        int[][] dp = new int[ m+1 ][ n+1 ];
        // dp init
        dp[ 0 ][ 0 ] = 1;
        // If a cell originally contains a 1, set the value of that cell to 0.
        // Otherwise, set it to the value of previous cell
        for( int i = 1; i < m; i++ )
            dp[ i ][ 0 ] = (board[ i ][ 0 ] == 1) ? 0 : dp[ i - 1 ][ 0 ];
        for( int j = 1; j < n; j++ )
            dp[ 0 ][ j ] = board[ 0 ][ j ] == 1 ? 0 : dp[ 0 ][ j - 1];
        
        for( int i = 1; i < m; i++ )
            for( int j = 1; j < n; j++ )
            {
                if( board[ i ][ j ] == 1 )
                    dp[ i ][ j ] = 0;
                else
                    dp[ i ][ j ] = dp[ i -1 ][ j ] + dp[ i ][ j - 1];
            }
        return dp[ m-1 ][ n-1 ];
    }
}