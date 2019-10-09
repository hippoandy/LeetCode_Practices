package app;

import java.util.*;

class Q909_snakes_and_ladders
{
    public int snakesAndLadders(int[][] board)
    {
        int n = board.length;
        boolean[] visited = new boolean[ n * n + 1 ];
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.offer( 1 );
        int step = 1;
        // bfs
        while( !q.isEmpty() )
        {
            int levelCount = q.size();
            for( int j = 0; j < levelCount; j++ )
            {
                int cur = q.remove();
                // choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6
                for( int i = 1; i <= 6; i++ )
                {
                    int next = cur + i;
                    Coord pos = numToPos( next, n );
                    // must take the ladder or snake if encountered
                    if( board[ pos.x ][ pos.y ] > 0 )
                        next = board[ pos.x ][ pos.y ];
                    if( next == n * n )
                        return step;
                    if( !visited[ next ] )
                    {
                        visited[ next ] = true;
                        q.offer( next );
                    }
                }
            }
            step++;
        }
        // not able to reach the dest
        return -1;
    }
    
    private Coord numToPos( int no, int size )
    {
        int r = (no - 1) / size, c = (no - 1) % size;
        int x = size - 1 - r, y = (r % 2 == 0) ? c : size - 1 - c;
        return new Coord( x, y );
    }
    
    // private int posToNum( int[] pos, int size )
    // {
    //     int r = (size - 1 - pos[ 0 ]);
    //     int c = (r % 2 == 0) ? pos[ 1 ] + 1: size - pos[ 1 ];
    //     return r * size + c;
    // }
    
    private class Coord
    {
        int x, y;
        public Coord( int x, int y ) { this.x = x; this.y = y; }
    }
}