package app;

import java.util.*;

// Runtime: 448 ms, faster than 5.04% of Java online submissions for Meeting Rooms II.
// Memory Usage: 50.5 MB, less than 5.11% of Java online submissions for Meeting Rooms II.
class Solution
{
    List<Integer> schedule = null;
    int max = Integer.MIN_VALUE;

    public int minMeetingRooms(int[][] intervals)
    {
        if( intervals == null ) return 0;
        if( intervals.length == 0 ) return 0;
        if( intervals[ 0 ].length == 0 ) return 1;

        for( int i = 0; i < intervals.length; i++ )
        {
            int s = intervals[ i ][ 0 ];
            int e = intervals[ i ][ 1 ];
            if( schedule == null )
            {
                schedule = new ArrayList<Integer>();
                // include time 0
                for( int j = 0; j <= e; j++ )
                    schedule.add( 0 );
                reserve( s, e );
            }
            else
            {
                int size = schedule.size();
                // next meeting starts later
                if( s > size-1 )
                {
                    // append empty time slot
                    for( int j = 0; j < e - size + 1; j++ )
                        schedule.add( 0 );
                    reserve( s, e );
                }
                // overlay with old meetings
                else if( e < size-1 )
                    reserve( s, e );
                // partial overlay
                else
                {
                    // add new time slot for non-intercepted region
                    for( int j = 0; j <= e-size; j++ )
                        schedule.add( 0 );
                    reserve( s, e );
                }
            }
        }
        return max;
    }
    
    private void reserve( int s, int e )
    {
        for( int j = s; j < e; j++ )
        {
            schedule.set( j, schedule.get( j ) + 1 );
            max = (schedule.get( j ) > max) ? schedule.get( j ) : max;
        }
    }
}