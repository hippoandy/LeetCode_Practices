package app;

import java.util.*;

class Q1101_the_earliest_moment_when_everyone_become_friends
{
    public int earliestAcq(int[][] logs, int N)
    {
        if( N < 2 ) throw new IllegalArgumentException( "Num of people less than 2!" );
        if( logs == null || logs.length == 0 ) return -1;

        DSU dsu = new DSU( N );

        Arrays.sort( logs, (a, b) -> a[ 0 ] - b[ 0 ] );
        int timestamp = -1;
        for( int[] log: logs )
        {
            timestamp = log[ 0 ];
            dsu.unify( log[ 1 ], log[ 2 ] );
            if( dsu.getCount() == 1 ) return timestamp;
        }
        return ( dsu.getCount() != 1 ) ? -1 : timestamp;
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