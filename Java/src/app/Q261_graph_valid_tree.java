package app;

class Q261_graph_valid_tree
{
    public boolean validTree(int n, int[][] edges)
    {
        if( n < 0 ) return false;
        if( n == 0 ) return true;
        
        DSU dsu = new DSU( n );
        
        for( int[] e: edges )
        {
            int u = e[ 0 ], v = e[ 1 ];
            // if there is a cycle...
            if( dsu.equivalent( u, v ) ) return false;
            else
                dsu.unify( u, v );
        }
        // the tree should be the only component left
        return dsu.getCount() == 1;
    }
    
    private class DSU
    {
        private int[] parent;
        private int[] rank;
        private int components;

        public DSU( int n )
        {
            this.parent = new int[ n ];
            this.rank = new int[ n ];
            this.components = 0;
            for( int i = 0; i < n; i++ )
            {
                this.parent[ i ] = i;
                this.rank[ i ] = 0;
                this.components++;
            }
        }
        
        public boolean equivalent( int x, int y )
        {
            return find( x ) == find( y );
        }
        
        public int find( int x )
        {
            while( x != this.parent[ x ] )
            {
                // path compression
                this.parent[ x ] = this.parent[ this.parent[ x ] ];
                x = this.parent[ x ];
            }
            return x;
        }
        
        public void unify( int x, int y )
        {
            int p1 = find( x ), p2 = find( y );
            if( p1 != p2 )
            {
                if( rank[ p1 ] > rank[ p2 ] ) this.parent[ p2 ] = p1;
                else if( rank[ p1 ] < rank[ p2 ] ) this.parent[ p1 ] = p2;
                else
                {
                    this.parent[ p2 ] = p1;
                    this.rank[ p1 ] += 1;
                }
                this.components--;
            }
        }
        
        public int getCount()
        { return this.components; }
    }
}