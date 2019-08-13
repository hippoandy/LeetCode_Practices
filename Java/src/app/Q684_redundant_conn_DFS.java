// ref. https://leetcode.com/problems/redundant-connection/discuss/163973/dfs-and-union-find

package app;

import java.util.*;

// Runtime: 15 ms, faster than 9.02% of Java online submissions for Redundant Connection.
// Memory Usage: 37.8 MB, less than 96.97% of Java online submissions for Redundant Connection.
class Q684_redundant_conn_DFS
{
    Map<Integer, List<Integer>> graph;

    public int[] findRedundantConnection(int[][] edges)
    {
        // build the graph
        graph = new HashMap<Integer, List<Integer>>();
        for( int i = 1; i <= edges.length; i++ )
            graph.put( i, new ArrayList<Integer>() );

        for( int[] edge: edges )
        {
            Set<Integer> visited = new HashSet<Integer>();
            // if the currend is not added to the graph yet and the node u is able to reach v
            // the current edge is a redundant edge!
            if( dfs( edge[ 0 ], edge[ 1 ], visited ) ) return edge;

            // the edge is not redundant, add the current edge to the graph
            // this is an undirected graph
            graph.get( edge[ 0 ] ).add( edge[ 1 ] );
            graph.get( edge[ 1 ] ).add( edge[ 0 ] );
        }
        return new int[ 0 ];
    }
    
    private boolean dfs( int u, int v, Set<Integer> visited )
    {
        if( u == v ) return true;
        for( int nei: graph.get( u ) )
            if( visited.add( nei ) )
                if( dfs( nei, v, visited ) ) return true;
        return false;
    }
}