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

        // sort the input by the start time
        Arrays.sort( intervals, new Comparator<int[]>()
        {   @Override
            public int compare( int[] a, int[] b )
            { return a[ 0 ] - b[ 0 ]; }
        });
        
        LinkedList<int[]> merge = new LinkedList<int[]>();
        for( int[] i: intervals )
        {
            // the very first element or the start of the next interval is larger than the current end
            // no overlap!
            if( merge.isEmpty() || merge.getLast()[ 1 ] < i[ 0 ] )
                merge.add( i );
            // there is an overlap
            else
                merge.getLast()[ 1 ] = (merge.getLast()[ 1 ] > i[ 1 ]) ? merge.getLast()[ 1 ] : i[ 1 ];
        }
        return merge.toArray( new int[ merge.size() ][ 2 ] );
    }
}