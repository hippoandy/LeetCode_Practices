package app;

import java.util.*;

class Q1135_connecting_cities_with_min_cost
{
    public int minimumCost(int N, int[][] connections)
    {
        DSU dsu = new DSU( N );

        // sort by cost, this step is important!
        Arrays.sort( connections, new Comparator<int[]>()
        {   @Override
            public int compare( int[] a, int[] b )
            { return a[ 2 ] - b[ 2 ]; }
        });
        
        int cost = 0;
        for( int[] conn: connections )
            if( !dsu.equivalent( conn[ 0 ], conn[ 1 ] ) )
            {
                dsu.unify( conn[ 0 ], conn[ 1 ] );
                cost += conn[ 2 ];
            }
        return ( dsu.getCount() == 1 ) ? cost : -1; // the cities are not fully connected
    }
    
    private class DSU
    {
        private int[] parent;
        private int components;
        
        public DSU( int n )
        {
            this.parent = new int[ n+1 ];
            this.components = 0;

            for( int i = 1; i <= n; i++ )
            {
                this.parent[ i ] = i;
                this.components++;
            }
        }
        
        public int find( int x )
        {
            while( x != this.parent[ x ] )
            {   // path compression
                this.parent[ x ] = this.parent[ this.parent[ x ] ];
                x = this.parent[ x ];
            }
            return x;
        }
        
        public void unify( int x, int y )
        {
            int p1 = find( x );
            int p2 = find( y );
            if( p1 != p2 )
            {
                this.components--;
                this.parent[ p2 ] = p1;
            }
        }
        
        public boolean equivalent( int x, int y )
        { return find( x ) == find( y ); }
        
        public int getCount()
        { return this.components; }
    }
}