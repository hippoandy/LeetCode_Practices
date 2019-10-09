package app;

import java.util.*;

class Q568_max_vacation_days_MEMO
{
    private int backtracking( int[][] flights, int[][] days, int currCity, int currWeek, int[][] memo )
    {
        if( currWeek == days[ 0 ].length )
            return 0;
        if( memo[ currCity ][ currWeek ] != Integer.MIN_VALUE )
            return memo[ currCity ][ currWeek ];
        
        int max = 0;
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
                int vac = cur.v + backtracking( flights, days, cur.k, currWeek+1, memo );
                max = Math.max( max, vac );
            }
        }
        memo[ currCity ][ currWeek ] = max;
        return max;
    }
    
    private static class Pair
    {
        int k, v;
        public Pair( int k, int v ) { this.k = k; this.v = v; }
    }

    public int maxVacationDays(int[][] flights, int[][] days)
    {
        // memo
        int[][] memo = new int[ flights.length ][ days[ 0 ].length ];
        for( int[] l: memo )
            Arrays.fill( l, Integer.MIN_VALUE );

        return backtracking( flights, days, 0, 0, memo );
    }
}