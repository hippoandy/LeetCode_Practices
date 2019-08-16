package app;

import java.util.*;

// Runtime: 7 ms, faster than 71.52% of Java online submissions for Meeting Rooms II.
// Memory Usage: 38 MB, less than 46.18% of Java online submissions for Meeting Rooms II.
class Q253_meeting_rooms_2_MINHEAP
{
    public int minMeetingRooms(int[][] intervals)
    {
        if( intervals == null ) return 0;
        if( intervals.length == 0 ) return 0;
        if( intervals[ 0 ].length == 0 ) return 1;
        
        // sort the intervals by start time (ascending order)
        Arrays.sort(
            intervals,
            new Comparator<int[]>()
            {   @Override
                public int compare( int[] a, int[] b )
                { return a[ 0 ] - b[ 0 ]; }
        });
        
        // min-heap
        PriorityQueue<Integer> scheduler = new PriorityQueue<Integer>(
            new Comparator<Integer>()
            {   @Override
                public int compare( Integer a, Integer b )
                { return a - b; }
        });
        // add the first meeting
        scheduler.add( intervals[ 0 ][ 1 ] ); // store the end time
        
        // traverse the remaining meetings
        for( int i = 1; i < intervals.length; i++ )
        {
            // remember the heap stores the end time of the previous meeting
            // since it's min-heap, it allow us to know when the earliest room will be released
            // release the room
            if( intervals[ i ][ 0 ] >= scheduler.peek() ) scheduler.remove();
            scheduler.offer( intervals[ i ][ 1 ] );
        }
        return scheduler.size();
    }
}