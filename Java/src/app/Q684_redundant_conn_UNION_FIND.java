// ref. https://leetcode.com/problems/redundant-connection/discuss/163973/dfs-and-union-find

package app;

// Runtime: 1 ms, faster than 81.32% of Java online submissions for Redundant Connection.
// Memory Usage: 39.7 MB, less than 63.64% of Java online submissions for Redundant Connection.
class Q684_redundant_conn_UNION_FIND
{
    public int[] findRedundantConnection(int[][] edges)
    {
        DSU dsu = new DSU( edges.length );
        
        for( int[] edge: edges )
        {
            int u = edge[ 0 ];
            int v = edge[ 1 ];
            // if the currend is not added to the graph yet and the node u is able to reach v
            // the current edge is a redundant edge!
            if( dsu.equivalent( u, v ) )
                return edge;
            else
                dsu.unify( u, v );
        }
        return new int[ 0 ];
    }
    
    private class DSU
    {
        int[] parent;

        public DSU( int n )
        {
            this.parent = new int[ n+1 ];
            // assign the id
            for( int i = 1; i <= n; i++ )
                this.parent[ i ] = i;
        }
        
        public int find( int id )
        {
            return (id == this.parent[ id ]) ? id : (this.parent[ id ] = find( this.parent[ id ] ));
        }
        
        public boolean equivalent( int x, int y )
        {
            return find( x ) == find( y );
        }
        
        public void unify( int x, int y )
        {
            this.parent[ find( x ) ] = find( y );
        }
    }
}