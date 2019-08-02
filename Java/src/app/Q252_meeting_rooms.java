package app;

import java.util.*;

class Q252_meeting_rooms
{
    public boolean canAttendMeetings(int[][] intervals)
    {
        Arrays.sort( intervals, new Comparator<int[]>()
        {   @Override
            public int compare( int[] i1, int[] i2 )
            {   // sort by start time (ascending order: a - b)
                return i1[ 0 ] - i2[ 0 ];
            }
        });
        
        // make sure each meeting ends before the next one start
        for( int i = 0; i < intervals.length-1; i++ )
            // the end time of the current meeting is later than the next one's start time
            if( intervals[ i ][ 1 ] > intervals[ i+1 ][ 0 ] ) return false;
        return true;
    }
}