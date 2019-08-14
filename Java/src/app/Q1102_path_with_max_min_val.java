// ref. https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/322926/Simple-Python-Priority-Queue-Solution

package app;

import java.util.*;

// Runtime: 117 ms, faster than 75.57% of Java online submissions for Path With Maximum Minimum Value.
// Memory Usage: 54.6 MB, less than 100.00% of Java online submissions for Path With Maximum Minimum Value.
class Q1102_path_with_max_min_val
{
    public int maximumMinimumPath(int[][] A)
    {
        if( A == null ) throw new IllegalArgumentException( "Maze is null!" );
        int R = A.length;
        if( R == 0 ) throw new IllegalArgumentException( "Maze is null!" );
        int C = A[ 0 ].length;
        if( C == 0 ) throw new IllegalArgumentException( "Maze is null!" );
        
        int[][] dirs = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( new Comparator<int[]>()
        {   @Override
            public int compare( int[] a, int[] b )
            { return b[ 0 ] - a[ 0 ]; } // compare the score
        });
        
        // store the score at the first element
        pq.offer( new int[]{ A[ 0 ][ 0 ], 0, 0 } );
        int min = A[ 0 ][ 0 ];
        // marked as visited
        A[ 0 ][ 0 ] = -1;
        // BFS
        while( !pq.isEmpty() )
        {
            int[] cur = pq.remove();
            // get the min value along the path
            min = (cur[ 0 ] < min) ? cur[ 0 ] : min;
            // if the cur reach the end point (R-1, C-1)
            if( cur[ 1 ] == R-1 && cur[ 2 ] == C-1 ) return min;
            
            for( int[] dir: dirs )
            {
                int x = cur[ 1 ] + dir[ 0 ], y = cur[ 2 ] + dir[ 1 ];
                // if out of bound or visited
                if( x < 0 || y < 0 || x >= R || y >= C || A[ x ][ y ] == -1 ) continue;
                
                pq.offer( new int[]{ A[ x ][ y ], x, y } );
                A[ x ][ y ] = -1;
            }
        }
        throw null;
    }
}