// https://leetcode.com/problems/daily-temperatures/discuss/109869/JavaC%2B%2B-Clean-Code

package app;

import java.util.*;

class Q739_daily_temperatures
{
    // Runtime: 8 ms, faster than 88.85% of Java online submissions for Daily Temperatures.
    // Memory Usage: 42.8 MB, less than 85.95% of Java online submissions for Daily Temperatures.
    // public int[] dailyTemperatures(int[] T)
    // {
    //     int n = T.length;
    //     int[] waits = new int[ n ];
    //     Arrays.fill( waits, 0 );
    //     // max. temperature is 100
    //     // store the corresponding index of a certain temperature in T
    //     int[] next = new int[ 101 ];
    //     for( int i = n - 1; i >= 0; i-- )
    //     {
    //         int earliest = Integer.MAX_VALUE;
    //         // try to find the earliest temp in T that is larger than the current temperature
    //         // var earliest stores the index if found
    //         for( int j = T[ i ] + 1; j <= 100; j++ )
    //         {
    //             if( next[ j ] != 0 )
    //                 earliest = Math.min( earliest, next[ j ] );
    //         }
    //         // find a earliest temp that is larger than current
    //         if( earliest != Integer.MAX_VALUE )
    //             waits[ i ] = earliest - i;
    //         // record the index of the current temp.
    //         next[ T[ i ] ] = i;
    //     }
    //     return waits;
    // }

    // Runtime: 57 ms, faster than 45.54% of Java online submissions for Daily Temperatures.
    // Memory Usage: 43.7 MB, less than 43.80% of Java online submissions for Daily Temperatures.
    public int[] dailyTemperatures(int[] T)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[ T.length ];
        
        for( int i = T.length-1; i >= 0; i-- )
        {
            // pop the stack if the pre temp is lower than current
            while( !stack.isEmpty() && T[ i ] >= T[ stack.peek() ] ) stack.pop();
            ans[ i ] = (stack.isEmpty()) ? 0 : stack.peek() - i;
            stack.push( i );
        }
        return ans;
    }
}
