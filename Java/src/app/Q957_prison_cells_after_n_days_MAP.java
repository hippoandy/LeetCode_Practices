// ref. https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14

package app;

import java.util.*:

class Q957_prison_cells_after_n_days_BF
{
    public int[] prisonAfterNDays(int[] cells, int N)
    {
        if( cells == null || cells.length == 0 ) return new int[ 0 ];
        if( N < 1 ) throw new IllegalArgumentException( "Num. of days less than 1!" );
        
        int len = cells.length;
        
        // 8 cells, only 6 cells will change, there are 2^64 different states, means there will be a cycle!!
        // use a map to record the state seen so far
        Map<String, Integer> seen_states = new HashMap<String, Integer>();

        int[] next = null;
        while( N > 0 )
        {
            next = new int[ len ];

            seen_states.put( Arrays.toString( cells ), N );
            N--;

            for( int i = 1; i < len-1; i++ )
                if( cells[ i-1 ] == cells[ i+1 ] )
                    next[ i ] = 1;
            cells = next;

            // while encounter a cycle, the current N should be much smaller than the recorded N
            if( seen_states.containsKey( Arrays.toString( cells ) ) )
                N %= seen_states.get( Arrays.toString( cells ) ) - N;
        }
        return next;
    }
}