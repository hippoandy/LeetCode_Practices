package app;

import java.util.*;

// Runtime: 2 ms, faster than 72.76% of Java online submissions for Relative Sort Array.
// Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Relative Sort Array.
class Q1122_relative_sort_arr
{
    public int[] relativeSortArray(int[] arr1, int[] arr2)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for( int a: arr1 ) map.put( a, map.getOrDefault( a, 0 ) + 1 );
        
        int idx = 0;
        for( int a: arr2 )
        {
            for( int i = 0; i < map.get( a ); i++ ) arr1[ idx++ ] = a;
            map.remove( a );
        }
        if( map.size() > 0 )
        {
            int[] remains = new int[ map.size() ];
            int i = 0;
            for( int k: map.keySet() ) remains[ i++ ] = k;
            Arrays.sort( remains );

            for( int k: remains )
            {
                for( int j = 0; j < map.get( k ); j++ ) arr1[ idx++ ] = k;
            }
        }
        return arr1;
    }
}