// ref. https://www.wikiwand.com/en/Dijkstra%27s_algorithm

package app;

import java.util.*;

// Runtime: 59 ms, faster than 32.37% of Java online submissions for Network Delay Time.
// Memory Usage: 53.7 MB, less than 44.27% of Java online submissions for Network Delay Time.
class Q743_network_delay_time_DIJKSTRA
{
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K)
    {
        // 1. build the graph
        Map<Integer, List<int[]>> graph = new HashMap<Integer, List<int[]>>();
        for( int[] edge: times )
        {
            if( !graph.containsKey( edge[ 0 ] ) )
            {
                List<int[]> neighbor = new ArrayList<int[]>();
                neighbor.add( new int[]{ edge[ 1 ], edge[ 2 ] } );
                graph.put( edge[ 0 ], neighbor );
            }
            else
                graph.get( edge[ 0 ] ).add( new int[]{ edge[ 1 ], edge[ 2 ] } );
        }

        // 2. [OPTION 3] run improved dijkstra to traverse the graph
        if( !dijkstra_PQ( graph, N, K ) ) return -1;

        // 3. get the result
        int ans = 0;
        for( int cand: dist.values() )
            ans = Math.max( ans, cand );
        return ans;
    }

    // dijkstra with Priority Queue
    // refer to: https://www.wikiwand.com/en/Dijkstra%27s_algorithm
    private boolean dijkstra_PQ( Map<Integer, List<int[]>> graph, int N, int start )
    {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(
            (p1, p2) -> p1[ 0 ] - p2[ 0 ]
        );

        /*** init ***/
        q.offer( new int[]{ 0, start } );

        dist = new HashMap<Integer, Integer>();

        while( !q.isEmpty() )
        {
            /*** extract min ***/
            int[] cur = q.remove();
            // see how the graph is built!!
            int d = cur[ 0 ], n = cur[ 1 ];
            // visited, skip!
            if( dist.containsKey( n ) ) continue;

            /*** append visited ***/
            dist.put( n, d );
            if( graph.containsKey( n ) )
                for( int[] edge: graph.get( n ) )
                {
                    // check if neighbor is already visited
                    // see how the graph is built!!
                    if( !dist.containsKey( edge[ 0 ] ) )
                        q.offer( new int[]{ d+edge[ 1 ], edge[ 0 ] } );
                }
        }

        if( dist.size() != N ) return false;
        return true;
    }
}