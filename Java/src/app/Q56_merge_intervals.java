package app;

import java.util.*;

// Runtime: 6 ms, faster than 88.63% of Java online submissions for Merge Intervals.
// Memory Usage: 41 MB, less than 69.19% of Java online submissions for Merge Intervals.
class Q56_merge_intervals
{
    public int[][] merge(int[][] intervals)
    {
        if( intervals == null ) return new int[ 0 ][ 0 ];
        if( intervals.length == 0 ) return new int[ 0 ][ 0 ];

        Arrays.sort( intervals,
            new Comparator<int[]>()
            {   @Override
                public int compare( int[] i1, int[] i2 )
                {
                    // sort by start
                    return (i1[ 0 ] - i2[ 0 ]);
                }
            }
        );
        
        LinkedList<int[]> merged = new LinkedList<int[]>();
        for( int[] i: intervals )
        {
            if( merged.size() == 0 || merged.getLast()[ 1 ] < i[ 0 ] )
                merged.add( i );
            else
                // there is an overlap
                merged.getLast()[ 1 ] = (i[ 1 ] > merged.getLast()[ 1 ]) ? i[ 1 ] : merged.getLast()[ 1 ];
        }
        
        return merged.toArray( new int[ merged.size() ][ 2 ] );
    }
}