package app;

import java.util.*;


// dijsktra's algorithm!!

// Runtime: 7 ms, faster than 97.26% of Java online submissions for The Maze II.
// Memory Usage: 46 MB, less than 100.00% of Java online submissions for The Maze II
class Q505_the_maze_2
{
    public int shortestDistance(int[][] maze, int[] start, int[] dest )
    {
        if( maze == null || maze.length == 0 ) return -1;
        
        int m = maze.length, n = maze[ 0 ].length;
        
        // init the shortest path lent
        int[][] distance = new int[ m ][ n ];
        for( int[] row: distance ) Arrays.fill( row, Integer.MAX_VALUE );
        
        // distance to the start point is 0
        distance[ start[ 0 ] ][ start[ 1 ] ] = 0;
        
        // dir: D, R, U, L
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        
        // bfs
        Queue<Coord> q = new LinkedList<Coord>();
        q.offer( new Coord( start[ 0 ], start[ 1 ] ) );
        while( !q.isEmpty() )
        {
            Coord cur = q.remove();

            for( int[] dir: dirs )
            {
                int x = cur.x, y = cur.y, increased = 0;
                do
                {
                    x += dir[ 0 ];
                    y += dir[ 1 ];
                    
                    increased++;
                }
                while(
                    x >= 0 && y >= 0 &&
                    x < m  && y < n  &&
                    maze[ x ][ y ] == 0
                );
                // restore
                x -= dir[ 0 ];
                y -= dir[ 1 ];
                increased--;
                
                // dijsktra!!
                if( distance[ cur.x ][ cur.y ] + increased < distance[ x ][ y ] )
                {
                    q.offer( new Coord( x, y ) );
                    // update shortest path
                    distance[ x ][ y ] = distance[ cur.x ][ cur.y ] + increased;
                }
            }
        }
        return (distance[ dest[ 0 ] ][ dest[ 1 ] ] == Integer.MAX_VALUE) ? -1 : distance[ dest[ 0 ] ][ dest[ 1 ] ];
    }
    
    private class Coord
    {
        int x, y, dist;
        public Coord( int x, int y ) { this.x = x; this.y = y; }
    }
}