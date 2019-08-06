// ref. https://leetcode.com/problems/minimum-area-rectangle/discuss/192025/Java-N2-Hashmap

package app;

import java.util.*;

class Q939_min_area_rectangle
{
    public int minAreaRect(int[][] points)
    {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for( int[] p: points )
        {
            if( !map.containsKey( p[ 0 ] ) )
                map.put( p[ 0 ], new HashSet<Integer>() );
            map.get( p[ 0 ] ).add( p[ 1 ] );
        }
        
        int min = Integer.MAX_VALUE;
        // check if we are able to find the other two diagonal points. If they exist, we found a rectangle.
        for( int[] p1: points )
            for( int[] p2: points )
            {
                if( p1[ 0 ] == p2[ 0 ] || p1[ 1 ] == p2[ 1 ] ) continue;
                if(
                    map.get( p1[ 0 ] ).contains( p2[ 1 ] ) &&
                    map.get( p2[ 0 ] ).contains( p1[ 1 ] )
                )
                {
                    min = Math.min( min,
                        Math.abs( p2[ 0 ] - p1[ 0 ] ) * Math.abs( p2[ 1 ] - p1[ 1 ] )
                    );
                }
            }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}