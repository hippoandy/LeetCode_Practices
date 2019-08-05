package app;

import java.util.*;

// Runtime: 4 ms, faster than 66.02% of Java online submissions for The Maze.
// Memory Usage: 46.2 MB, less than 82.86% of Java online submissions for The Maze.
class Q490_the_maze
{
    public boolean hasPath(int[][] maze, int[] start, int[] destination)
    {
        int m = maze.length, n = maze[ 0 ].length;
        boolean[][] visited = new boolean[ m ][ n ];

        // directions: R, L, D, U
        int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        Queue<int[]> q = new LinkedList<int[]>();
        q.add( start );
        visited[ start[ 0 ] ][ start[ 1 ] ] = true;
        while( !q.isEmpty() )
        {
            int[] cur = q.remove();
            if( cur[ 0 ] == destination[ 0 ] && cur[ 1 ] == destination[ 1 ] )
                return true;
            for( int[] dir: dirs )
            {
                int x = cur[ 0 ] + dir[ 0 ];
                int y = cur[ 1 ] + dir[ 1 ];
                while(
                    x >= 0 && y >= 0 &&
                    x <= m-1 && y <= n-1 &&
                    maze[ x ][ y ] == 0
                )
                {
                    // keep moving
                    x += dir[ 0 ];
                    y += dir[ 1 ];
                }
                // while will stop until the condition is not able to fulfill,
                // therefore, we have to restore to previous stage
                x = x - dir[ 0 ];
                y = y - dir[ 1 ];
                if( !visited[ x ][ y ] )
                {
                    // potential start points for next stage
                    q.add( new int[]{ x, y } );
                    visited[ x ][ y ] = true;
                }
            }
        }
        return false;
    }
    
//     // Time limit exceeded!!
//     int m, n;
//     public boolean hasPath(int[][] maze, int[] start, int[] destination)
//     {
//         if( maze == null ) return false;
//         m = maze.length;
//         if( m == 0 ) return false;
//         n = maze[ 0 ].length;
//         if( n == 0 ) return false;
//         boolean ans = dfs( maze, start[ 0 ], start[ 1 ], destination[ 0 ], destination[ 1 ], '-' );
//         return ans;
//     }
//     private boolean dfs( int[][] maze, int c1, int c2, int e1, int e2, char dir )
//     {
//         if( c1 < 0 || c1 >= m || c2 < 0 || c2 >= n ) return false;

//         int n1 = c1, n2 = c2;
//         if( dir == 'l' )
//             while( c2 > 0 && maze[ c1 ][ c2-1 ] != 1 )
//                 n2 -= 1;
//         else if( dir == 'r' )
//             while( c2 < n-1 && maze[ c1 ][ c2+1 ] != 1 )
//                 n2 += 1;
//         else if( dir == 'u' )
//             while( c1 > 0 && maze[ c1-1 ][ c2 ] != 1 )
//                 n1 -= 1;
//         else if( dir == 'd')
//             while( c1 < m-1 && maze[ c1+1 ] [ c2 ] != 1 )
//                 n1 += 1;

//         // check if reaching the dest
//         if( n1 == e1 && n2 == e2 ) return true;
        
//         // chose a direction
//         boolean l = (c2 > 0)   ? dfs( maze, n1, n2, e1, e2, 'l' ) : false;
//         boolean r = (c2 < n-1) ? dfs( maze, n1, n2, e1, e2, 'r' ) : false;
//         boolean u = (c1 > 0)   ? dfs( maze, n1, n2, e1, e2, 'u' ) : false;
//         boolean d = (c1 < m-1) ? dfs( maze, n1, n2, e1, e2, 'd' ) : false;
        
//         return l || r || u || d;
//     }
}