// ref. https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution

package app;

// Runtime: 2 ms, faster than 47.14% of Java online submissions for Number of Islands.
// Memory Usage: 41.2 MB, less than 59.94% of Java online submissions for Number of Islands.
class Q200_num_of_islands
{
    int m, n;
    public int numIslands(char[][] grid)
    {
        if( grid == null ) return 0;
        m = grid.length;
        if( m == 0 ) return 0;
        n = grid[ 0 ].length;
        if( n == 0 ) return 0;

        int count = 0;
        
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
                if( grid[ i ][ j ] == '1' )
                {
                    dfs( grid, i, j );
                    count++;
                }
        return count;
    }
    
    private void dfs( char[][] grid, int i, int j )
    {
        // out of bound
        if( i < 0 || i >= m || j < 0 || j >= n ) return;
        
        if( grid[ i ][ j ] == '1' )
        {
            // mark the visited
            grid[ i ][ j ] = '0';

            // trace for 4 directions
            dfs( grid, i-1, j );
            dfs( grid, i+1, j );
            dfs( grid, i, j-1 );
            dfs( grid, i, j+1 );
        }
    }
}

// failed
// class Solution
// {
//     int count = 0;
//     int m, n;
//     public int numIslands(char[][] grid)
//     {
//         if( grid == null ) return 0;
//         m = grid.length;
//         if( m == 0 ) return 0;
//         n = grid[ 0 ].length;
//         if( n == 0 ) return 0;

//         boolean[][] visited = new boolean[ m ][ n ];
        
//         for( int i = 0; i < m; i++ )
//             for( int j = 0; j < n; j++ )
//                 if( grid[ i ][ j ] == '1' && !visited[ i ][ j ] )
//                 {
//                     // check the neighbor
//                     if( i >= 1   && visited[ i-1 ][ j ] ) continue;
//                     if( i < m-2 && visited[ i+1 ][ j ] ) continue;
//                     if( j >= 1   && visited[ i ][ j-1 ] ) continue;
//                     if( j < n-2 && visited[ i ][ j+1 ] ) continue;
//                     dfs( grid, visited, i, j );
//                     count++;
//                 }
//         return count;
//     }
    
//     private void dfs( char[][] grid, boolean[][] visited, int i, int j )
//     {
//         // out of bound
//         if( i < 0 || i >= m || j < 0 || j >= n ) return;
//         if( visited[ i ][ j ] ) return;

//         visited[ i ][ j ] = true;
        
//         // trace for 4 directions
//         if( i > 1   && grid[ i-1 ][ j ] == '1' ) dfs( grid, visited, i-1, j );
//         if( i < m-2 && grid[ i+1 ][ j ] == '1' ) dfs( grid, visited, i+1, j );
//         if( j > 1   && grid[ i ][ j-1 ] == '1' ) dfs( grid, visited, i, j-1 );
//         if( j < n-2 && grid[ i ][ j+1 ] == '1' ) dfs( grid, visited, i, j+1 );
//     }
// }