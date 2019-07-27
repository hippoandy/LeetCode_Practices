package app;

class Q980_unique_paths_3
{
    int m, n, count;
    int ta, tb;
    public int uniquePathsIII(int[][] grid)
    {
        if( grid == null ) return 0;
        m = grid.length;
        if( m == 0 ) return 0;
        n = grid[ 0 ].length;
        if( n == 0 ) return 0;

        int sa = 0, sb = 0, todo = 0;
        // 1. find the starting point
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j ++ )
            {
                // count how many grid to reach
                if( grid[ i ][ j ] != -1 ) todo++;
                // the start point
                if( grid[ i ][ j ] == 1 )
                { sa = i; sb = j; }
                // the end point
                if( grid[ i ][ j ] == 2 )
                { ta = i; tb = j; }
            }
        // start traversing
        dfs( grid, sa, sb, todo );
        return count;
    }
    
    private void dfs( int[][] grid, int i, int j, int todo )
    {
        int cur = grid[ i ][ j ];
        todo--;
        // all the cell has been traverse
        if( todo < 0 ) return;
        if( i == ta && j == tb )
        {
            // check if there is no 0
            if( todo == 0 ) count++;
            return;
        }
        
        // mark the location
        grid[ i ][ j ] = 3; // 3 % 2 = 1!!
        // traverse 4 directions
        if( i > 0 )
        {   // if the grid is reachable, % 2 since the end point is marked by 2
            if( grid[ i - 1 ][ j ] % 2 == 0 ) // case for 0, 1 or 2, -1 % 2 = -1!!
                dfs( grid, i - 1, j, todo );
        }
        if( i < m - 1 )
        {   // if the grid is reachable
            if( grid[ i + 1 ][ j ] % 2 == 0 ) // case for 0, 1 or 2, -1 % 2 = -1!!
                dfs( grid, i + 1, j, todo );
        }
        if( j > 0 )
        {   // if the grid is reachable
            if( grid[ i ][ j - 1 ] % 2 == 0 ) // case for 0, 1 or 2, -1 % 2 = -1!!
                dfs( grid, i, j - 1, todo );
        }
        if( j < n - 1 )
        {   // if the grid is reachable
            if( grid[ i ][ j + 1 ] % 2 == 0 ) // case for 0, 1 or 2, -1 % 2 = -1!!
                dfs( grid, i, j + 1, todo );
        }
        // restore
        grid[ i ][ j ] = cur;
    }
}