// ref. https://leetcode.com/problems/critical-connections-in-a-network/discuss/382526/Tarjan-Algorithm-(DFS)-Python-Solution-with-explanation
// ref. https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
// ref. https://blog.csdn.net/QiHang_QiHang/article/details/78300054

package app;

import java.util.*;

class Q1192_critical_connections_in_a_network
{
    private void sccUntil( Graph g, int u, int parent, int[] disc, int times, int[] low )
    {
        // the node is already visited
        if( disc[ u ] != -1 ) return;

        disc[ u ] = low[ u ] = ++times;
        
        // go through all the neighbors
        for( int i = 0; i < g.neighbors[ u ].size(); i++ )
        {
            int v = g.neighbors[ u ].get( i );
            // not visited
            if( disc[ v ] == -1 )
                sccUntil( g, v, u, disc, times, low );
            if( v != parent )
                low[ u ] = Math.min( low[ u ], low[ v ] );
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        // build the graph
        Graph g = new Graph( n );
        // undirected graph!!!
        for( List<Integer> conn: connections )
        {
            g.addEdge( conn.get( 0 ), conn.get( 1 ) );
            g.addEdge( conn.get( 1 ), conn.get( 0 ) );
        }

        int[] disc = new int[ n ];
        int[] low = new int[ n ];
        
        for( int i = 0; i < n; i++ )
        {
            disc[ i ] = -1;
            low[ i ] = -1;
        }
        
        // start to find the strongly connected components
        // just started by the first node and do one SCC call
        // in the original trajan's algo,
        // we have to call sccUntil() for all the node
        sccUntil( g, 0, -1, disc, 0, low );
    
        // find the edge (u,v) where disc[ u ] < low[ v ]
        for( List<Integer> conn: connections )
            if( low[ conn.get( 0 ) ] > disc[ conn.get( 1 ) ] || low[ conn.get( 1 ) ] > disc[ conn.get( 0 ) ] )
                res.add( conn );
        return res;
    }
    
    /* Class Graph */
    private static class Graph
    {
        int numOfNodes;
        List<Integer>[] neighbors;

        public Graph( int n )
        {
            this.numOfNodes = n;
            this.neighbors = new List[ this.numOfNodes ];
            // build the adjacent list
            for( int i = 0; i < n; i++ )
                this.neighbors[ i ] = new ArrayList<Integer>();
        }

        public void addEdge( int u, int v ) { this.neighbors[ u ].add( v ); }

        public int getNumOfNodes() { return this.numOfNodes; }
    }
}