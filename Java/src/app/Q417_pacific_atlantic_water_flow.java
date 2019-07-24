// ref. https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90733/Java-BFS-and-DFS-from-Ocean

package app;

import java.util.*;

// Runtime: 8 ms, faster than 41.46% of Java online submissions for Pacific Atlantic Water Flow.
// Memory Usage: 46.4 MB, less than 18.31% of Java online submissions for Pacific Atlantic Water Flow.
class Q417_pacific_atlantic_water_flow
{
    List<List<Integer>> ans;
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix)
    {
        ans = new ArrayList<List<Integer>>();
        if( matrix == null ) return ans;
        m = matrix.length;
        if( m == 0 ) return ans;
        n = matrix[ 0 ].length;
        if( n == 0 ) return ans;
        
        boolean[][] pacific =  new boolean[ m ][ n ];
        boolean[][] atlantic = new boolean[ m ][ n ];

        // just start from all the cells at the borader
        for( int i = 0; i < m; i++ )
        {
            // the left boundary (Pacific)
            dfs( matrix, pacific, matrix[ i ][ 0 ], i, 0 );
            // the right boundary (Atlantic)
            dfs( matrix, atlantic, matrix[ i ][ n - 1 ], i, n - 1 );
        }
        for( int j = 0; j < n; j++ )
        {
            // the upper boundary (Pacific)
            dfs( matrix, pacific, matrix[ 0 ][ j ], 0, j );
            // the lower boundary (Atlantic)
            dfs( matrix, atlantic, matrix[ m - 1 ][ j ], m - 1, j );
        }
        
        // if both pacific[i][j] and atlantic[i][j] == true, the cell is able to travel to both the ocean
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
            {
                if( pacific[ i ][ j ] && atlantic[ i ][ j ] )
                    ans.add( new ArrayList<Integer>( Arrays.asList( i, j ) ) );
            }
        return ans;
    }
    
    private void dfs( int[][] matrix, boolean[][] visited, int height, int i, int j)
    {
        // out of bound
        if( i < 0 || i >= m || j < 0 || j >= n ) return;
        if( visited[ i ][ j ] ) return;
        if( matrix[ i ][ j ] < height ) return;
        
        visited[ i ][ j ] = true;
        
        // trace 4 directions
        // up
        dfs( matrix, visited, matrix[ i ][ j ], i-1, j );
        // down
        dfs( matrix, visited, matrix[ i ][ j ], i+1, j );
        // left
        dfs( matrix, visited, matrix[ i ][ j ], i, j-1 );
        // right
        dfs( matrix, visited, matrix[ i ][ j ], i, j+1 );
    }
}


// stackOverFlow!!
// class Solution
// {
//     List<List<Integer>> ans;
//     int m, n;
//     public List<List<Integer>> pacificAtlantic(int[][] matrix)
//     {
//         if( matrix == null ) return null;
//         m = matrix.length; n = matrix[ 0 ].length;
//         if( m == 0 || n == 0 ) return null;
        
//         ans = new ArrayList<List<Integer>>();
//         for( int i = 0; i < m; i++ )
//             for( int j = 0; j < n; j++ )
//                 dfs( matrix, matrix[i][j], i, j, i, j, false, false );
//         return ans;
//     }
    
//     private void dfs( int[][] matrix, int val, int i, int j, int origin_i, int origin_j, boolean reachP, boolean reachA )
//     {
//         // out of bound
//         if( i < 0 || i > m || j < 0 || j > n ) return;

//         // exists cell have height higher than the start point
//         if( matrix[ i ][ j ] > val ) return;
        
//         if( i == 0 || j == 0 ) reachP = true;
//         if( i == m - 1 || j == n - 1 ) reachA = true;
        
//         if( reachP && reachA )
//             ans.add( new ArrayList<Integer>( Arrays.asList( origin_i, origin_j ) ) );
        
//         // trace 4 directions
//         // up
//         dfs( matrix, val, i-1, j, origin_i, origin_j, reachP, reachA );
//         // down
//         dfs( matrix, val, i+1, j, origin_i, origin_j, reachP, reachA );
//         // left
//         dfs( matrix, val, i, j-1, origin_i, origin_j, reachP, reachA );
//         // right
//         dfs( matrix, val, i, j+1, origin_i, origin_j, reachP, reachA );
//     }

// }