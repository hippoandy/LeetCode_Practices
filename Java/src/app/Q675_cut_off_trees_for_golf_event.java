package app;

import java.util.*;

class Q675_cut_off_trees_for_golf_event
{
    public int cutOffTree(List<List<Integer>> forest)
    {
        // the tree should be cut in the order of the height
        PriorityQueue<Tree> pq = new PriorityQueue<Tree>( (a, b) -> a.h - b.h );
        for( int i = 0; i < forest.size(); i++ )
            for( int j = 0; j < forest.get( 0 ).size(); j++ )
            {
                int h = forest.get( i ).get( j );
                // not a grass
                if( h > 1 ) pq.offer( new Tree( i, j, h ) );
            }
    
        int ans = 0, sx = 0, sy = 0;
        while( !pq.isEmpty() )
        {
            Tree pop = pq.remove();
            int d = dist( forest, sx, sy, pop.x, pop.y );
            // no available path to that location
            if( d < 0 ) return -1;
            
            ans += d;
            
            sx = pop.x; sy = pop.y;
        }
        return ans;
    }
    
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    // bfs
    private int dist( List<List<Integer>> forest, int sx, int sy, int tx, int ty )
    {
        // find the path from src to tar
        int m = forest.size(), n = forest.get( 0 ).size();
        
        Queue<Pos> q = new LinkedList<Pos>();
        // the step to the start point is 0
        q.offer( new Pos( sx, sy, 0 ) );
        
        boolean[][] visited = new boolean[ m ][ n ];
        visited[ sx ][ sy ] = true;
        while( !q.isEmpty() )
        {
            Pos cur = q.remove();
            // reach the dest
            if( cur.x == tx && cur.y == ty ) return cur.step;
            for( int[] dir: dirs )
            {
                int x = cur.x + dir[ 0 ], y = cur.y + dir[ 1 ];
                if( x < 0 || y < 0 || x >= m || y >= n ||
                    forest.get( x ).get( y ) == 0 ||
                    visited[ x ][ y ]
                 ) continue;
                
                visited[ x ][ y ] = true;
                q.offer( new Pos( x, y, cur.step+1 ) );
            }
        }
        // no path available
        return -1;
    }
    
    private class Pos
    {
        int x, y, step;
        public Pos( int x, int y, int step ) { this.x = x; this.y = y; this.step = step; }
    }
    
    private class Tree
    {
        int x, y, h;
        public Tree( int x, int y, int h ) { this.x = x; this.y = y; this.h = h; }
    }
}