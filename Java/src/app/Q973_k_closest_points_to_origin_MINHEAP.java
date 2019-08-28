package app;

import java.util.*;

// Runtime: 86 ms, faster than 5.29% of Java online submissions for K Closest Points to Origin.
// Memory Usage: 62 MB, less than 41.00% of Java online submissions for K Closest Points to Origin.
class Q973_k_closest_points_to_origin_MINHEAP
{
    
    public int[][] kClosest(int[][] points, int K)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>( (a, b ) -> a - b );
        
        Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
        
        for( int[] p: points )
        {
            int dist = p[ 0 ] * p[ 0 ] + p[ 1 ] * p[ 1 ];
            if( !map.containsKey( dist ) ) pq.offer( dist );
            map.computeIfAbsent( dist, x -> new ArrayList<int[]>() ).add( p );
        }

        List<int[]> ans = new ArrayList<int[]>();
        int i = K;
        while( i-- >= 1 && !pq.isEmpty() )
            ans.addAll( map.get( pq.remove() ) );
        ans = ans.subList( 0, K );
        return ans.toArray( new int[ ans.size() ][ 2 ] );
    }
    
    private class Pair
    {
        int[] point;
        int dist;
        public Pair( int[] p, int d ){ this.point = p; this.dist = d; }
    }
}