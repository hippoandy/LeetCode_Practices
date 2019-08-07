package app;

import java.util.*;

class Q986_interval_list_intersections
{
    public int[][] intervalIntersection(int[][] A, int[][] B)
    {
        int i = 0, j = 0;
        LinkedList<int[]> ans = new LinkedList<int[]>();
        
        while( i < A.length && j < B.length )
        {
            int a = Math.max( A[ i ][ 0 ], B[ j ][ 0 ] );
            int b = Math.min( A[ i ][ 1 ], B[ j ][ 1 ] );

            if( a <= b ) ans.add( new int[]{a, b} );

            if( A[ i ][ 1 ] < B[ j ][ 1 ] )
                i++;
            else
                j++;
        }
        return ans.toArray( new int[ ans.size() ][ 2 ] );
    }
}