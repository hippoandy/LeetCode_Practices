// ref. https://www.wikiwand.com/en/Dijkstra%27s_algorithm

package app;

import java.util.*;

class Q743_network_delay_time
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
                neighbor.add( new int[]{ edge[ 2 ], edge[ 1 ] } );
                graph.put( edge[ 0 ], neighbor );
            }
            else
                graph.get( edge[ 0 ] ).add( new int[]{ edge[ 2 ], edge[ 1 ] } );
        }
        // 2. sort the neighbor by weight
        // O(ElogE)
        for( int node: graph.keySet() )
            Collections.sort( graph.get( node ), (a, b) -> a[ 0 ] - b[ 0 ] );
        
        // 3. maintain a list of weight to every node
        dist = new HashMap<Integer, Integer>();
        for( int node = 1; node <= N; node++ )
            dist.put( node, Integer.MAX_VALUE );
        
        // 4. [OPTION 1] run dfs to traverse the graph
        // Runtime: 83 ms, faster than 11.55% of Java online submissions for Network Delay Time.
        // Memory Usage: 47 MB, less than 79.81% of Java online submissions for Network Delay Time.
        // dfs( graph, K, 0 );

        // 4. [OPTION 2] run dijkstra to traverse the graph
        // Runtime: 63 ms, faster than 27.45% of Java online submissions for Network Delay Time.
        // Memory Usage: 53.1 MB, less than 49.41% of Java online submissions for Network Delay Time.
        // O(N^2)
        dijkstra( graph, N, K, 0 );
        
        // 5. get the result
        int ans = 0;
        for( int cand: dist.values() )
        {
            // no way to traverse to that node
            if( cand == Integer.MAX_VALUE ) return -1;
            ans = Math.max( ans, cand );
        }
        return ans;
    }
    
    // private void dfs( Map<Integer, List<int[]>> graph, int node, int elasped )
    // {
    //     // If some signal arrived earlier,
    //     // we don't need to broadcast it anymore.
    //     // Otherwise, we should broadcast the signal.
    //     if( elasped >= dist.get( node ) ) return;

    //     dist.put( node, elasped );
    //     // do the boradcast to the next node
    //     if( graph.containsKey( node ) )
    //     {
    //         for( int[] edge: graph.get( node ) )
    //             dfs( graph, edge[ 1 ], elasped + edge[ 0 ] );
    //     }
    // }
    
    private void dijkstra( Map<Integer, List<int[]>> graph, int N, int node, int elasped )
    {
        // init
        dist.put( node, elasped );
        boolean[] seen = new boolean[ N+1 ];
        while( true )
        {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            
            // try to get the node with shortest cost first
            for( int i = 1; i <= N; i++ )
                if( !seen[ i ] && dist.get( i ) < candDist )
                {
                    candDist = dist.get( i );
                    candNode = i;
                }
            // no such node found
            if( candNode < 0 ) break;

            seen[ candNode ] = true;
            if( graph.containsKey( candNode ) )
                for( int[] edge: graph.get( candNode ) )
                    // update the dist for a reached node
                    dist.put(
                        edge[ 1 ],
                        Math.min( dist.get( edge[ 1 ] ), dist.get( candNode ) + edge[ 0 ] )
                    );
        }
    }
}