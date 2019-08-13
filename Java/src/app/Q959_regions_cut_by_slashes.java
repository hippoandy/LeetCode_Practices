// ref. https://leetcode.com/problems/regions-cut-by-slashes/discuss/205680/JavaC%2B%2BPython-Split-4-parts-and-Union-Find

package app;

class Q959_regions_cut_by_slashes
{
    int n;
    public int regionsBySlashes(String[] grid)
    {
        if( grid == null || grid.length == 0 ) return 0;
        
        n = grid.length;
        DSU dsu = new DSU( n );

        for( int i = 0; i < n; i++ )
            for( int j = 0; j < n; j++ )
            {
                char c = grid[ i ].charAt( j );
                if( c != '\\' )
                {
                    dsu.unify( idx( i, j, 0 ), idx( i, j, 1 ) );
                    dsu.unify( idx( i, j, 2 ), idx( i, j, 3 ) );
                }
                if( c != '/' )
                {
                    dsu.unify( idx( i, j, 0 ), idx( i, j, 2 ) );
                    dsu.unify( idx( i, j, 1 ), idx( i, j, 3 ) );
                }
                
                // north & south
                // the connectivity of 0 & 3 for neighboring grid will never be blocked!
                if( i > 0 )
                    dsu.unify( idx( i, j, 0 ), idx( i-1, j, 3 ) );
                // east & west
                // the connectivity of 1 & 2 for neighboring grid will never be blocked!
                if( j > 0 )
                    dsu.unify( idx( i, j, 1 ), idx( i, j-1, 2 ) );
            }
        return dsu.getCount();
    }
    
    private int idx( int i, int j, int k )
    {
        return 4 * (i * n + j) + k;
    }
    
    private class DSU
    {
        private int[] parent;
        private int components;

        public DSU( int n )
        {
            this.parent = new int[ (n * n) * 4 ];
            this.components = 0;
            for( int i = 0; i < this.parent.length; i++ )
            {
                this.parent[ i ] = i;
                this.components++;
            }
        }
        
        public int find( int x )
        {
            return (x == this.parent[ x ]) ? x : (this.parent[ x ] = find( this.parent[ x ] ));
        }
        
        public void unify( int x, int y )
        {
            int p1 = find( x );
            int p2 = find( y );
            if( p1 != p2 )
            {
                this.components--;
                this.parent[ p1 ] = p2;
            }
        }
        
        public int getCount()
        { return this.components; }
    }
}