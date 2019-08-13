package app;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Number of Connected Components in an Undirected Graph.
// Memory Usage: 43.8 MB, less than 81.82% of Java online submissions for Number of Connected Components in an Undirected Graph.
class Q323_num_of_connected_components_in_an_undirected_graph
{
    public int countComponents(int n, int[][] edges)
    {
        if( n < 0 ) throw new IllegalArgumentException( "Num of nodes can't be neg!" );

        DSU dsu = new DSU( n );
        
        for( int[] e: edges )
        {
            int x = e[ 0 ], y = e[ 1 ];
            dsu.unify( x, y );
        }
        return dsu.getCount();
    }
    
    private class DSU
    {
        private int[] parent;
        private int components;

        public DSU( int n )
        {
            this.parent = new int[ n ];
            this.components = 0;
            for( int i = 0; i < n; i++ )
            {
                this.parent[ i ] = i;
                this.components++;
            }
        }
        
        public int find( int id )
        {
            while( id != this.parent[ id ])
            {
                // path compression!
                this.parent[ id ] = this.parent[ this.parent[ id ] ];
                id = this.parent[ id ];
            }
            return id;
        }
        
        public void unify( int x, int y )
        {
            int p1 = find( x ), p2 = find( y );
            if( p1 != p2 )
            {
                this.parent[ p2 ] = p1;
                this.components--;
            }
        }
        
        public int getCount()
        { return this.components; }
    }
}