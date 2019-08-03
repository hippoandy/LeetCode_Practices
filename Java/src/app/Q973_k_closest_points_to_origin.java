package app;

import java.util.*;

// Runtime: 13 ms, faster than 78.81% of Java online submissions for K Closest Points to Origin.
// Memory Usage: 59.2 MB, less than 74.88% of Java online submissions for K Closest Points to Origin.
class Q973_k_closest_points_to_origin
{
    public int[][] kClosest(int[][] points, int K)
    {
        int n = points.length;
        int[] dists = new int[ n ];
        for( int i = 0; i < n; i++ )
            dists[ i ] = dist( points[ i ] );
        
        Arrays.sort( dists );
        int distK = dists[ K-1 ];
        List<int[]> ret = new LinkedList<int[]>();
        for( int i = 0; i < n; i++ )
            if( dist( points[ i ] ) <= distK )
                ret.add( points[ i ] );
        return ret.toArray( new int[ ret.size() ][ 2 ] );
    }
    
    private int dist( int[] p )
    {
        return p[ 0 ] * p[ 0 ] + p[ 1 ] * p[ 1 ];
    }
}