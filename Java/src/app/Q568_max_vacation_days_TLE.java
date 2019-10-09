package app;

import java.util.*;

class Q568_max_vacation_days_TLE
{
    int max = 0;

    private void backtracking( int[][] flights, int[][] days, int currCity, int currWeek, int tmp )
    {
        if( currWeek > days[ 0 ].length ) return;
        if( currWeek == days[ 0 ].length )
            max = (tmp > max) ? tmp : max;
        else
        {
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                (a, b) -> (a.v == b.v) ? a.k - b.k : b.v - a.v
            );
            for( int i = 0; i < days.length; i++ )
                // <key:value> == <city:days>
                pq.offer( new Pair( i, days[ i ][ currWeek ] ) );
            while( !pq.isEmpty()  )
            {
                Pair cur = pq.remove();
                // if the destination city is the currentCity
                // or there is a flight connected these 2 diff cities
                if( currCity == cur.k || flights[ currCity ][ cur.k ] == 1 )
                {
                    tmp += cur.v;
                    backtracking( flights, days, cur.k, currWeek+1, tmp );
                    // restore
                    tmp -= cur.v;
                }
            }
        }
    }
    
    private static class Pair
    {
        int k, v;
        public Pair( int k, int v ) { this.k = k; this.v = v; }
    }

    public int maxVacationDays(int[][] flights, int[][] days)
    {
        backtracking( flights, days, 0, 0, 0 );
        return max;
    }
}