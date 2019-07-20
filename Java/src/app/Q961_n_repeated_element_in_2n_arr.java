package app;

import java.util.*;

class Q961_n_repeated_element_in_2n_arr
{
    // Runtime: 24 ms, faster than 8.39% of Java online submissions for N-Repeated Element in Size 2N Array.
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for( int n: A )
        {
            map.put( n, map.getOrDefault( n, 0 ) + 1 );
            if( map.get( n ) == A.length/2 ) return n;
        }
        throw null;
    }
}