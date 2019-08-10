package app;

class Q695_max_area_of_island
{
    int max = 0;

    int m, n;
    public int maxAreaOfIsland(int[][] grid)
    {
        m = grid.length;
        n = grid[ 0 ].length;
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
                if( grid[ i ][ j ] == 1 )
                {
                    int count = dfs( grid, i, j );
                    max = (count > max) ? count : max;
                }
        return max;
    }
    
    private int dfs( int[][] grid, int i, int j )
    {
        if( i >= 0 && i < m && j >= 0 && j < n && grid[ i ][ j ] == 1 )
        {
            // mark the location
            grid[ i ][ j ] = 0;

            return 1 + dfs( grid, i-1, j ) + dfs( grid, i+1, j ) +
                       dfs( grid, i, j-1 ) + dfs( grid, i, j+1 );
        }
        return 0;
    }
}