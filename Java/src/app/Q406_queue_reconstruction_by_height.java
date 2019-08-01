package app;

import java.util.*;

// Runtime: 6 ms, faster than 88.37% of Java online submissions for Queue Reconstruction by Height.
// Memory Usage: 45.4 MB, less than 52.36% of Java online submissions for Queue Reconstruction by Height.
class Q406_queue_reconstruction_by_height 
{
    public int[][] reconstructQueue(int[][] people)
    {
        Arrays.sort( people, new Comparator<int[]>()
        {   @Override
            public int compare( int[] p1, int[] p2)
            {
                // descending order by height (b-a)
                // ascending order by k       (a-b)
                return (p1[ 0 ] == p2[ 0 ]) ? p1[ 1 ] - p2[ 1 ] : p2[ 0 ] - p1[ 0 ];
            }
        });
        
        List<int[]> output = new LinkedList<int[]>();
        for( int[] p : people )
            output.add( p[ 1 ], p );
        return output.toArray( new int[ output.size() ][ 2 ] );
    }
}