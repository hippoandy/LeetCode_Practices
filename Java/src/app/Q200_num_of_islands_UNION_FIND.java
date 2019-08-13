package app;

class Q200_num_of_islands_UNION_FIND
{
    public int numIslands(char[][] grid)
    {
        if( grid == null || grid.length == 0 ) return 0;
        
        int m = grid.length;
        int n = grid[ 0 ].length;
        
        DSU dsu = new DSU( grid );

        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
                if( grid[ i ][ j ] == '1' )
                {
                    // marked visited
                    grid[ i ][ j ] = '0';
                    // union 4 directions
                    if( i > 0 && grid[ i-1 ][ j ] == '1' )   dsu.unify( i * n + j, (i-1) * n + j );
                    if( i < m-1 && grid[ i+1 ][ j ] == '1' ) dsu.unify( i * n + j, (i+1) * n + j );
                    if( j > 0 && grid[ i ][ j-1 ] == '1' )   dsu.unify( i * n + j, i * n + (j-1)  );
                    if( j < n-1 && grid[ i ][ j+1 ] == '1' ) dsu.unify( i * n + j, i * n + (j+1) );
                }
        return dsu.getCount();
    }
    
    class DSU
    {
        int[] parent;
        int components;
        public DSU( char[][] grid )
        {
            int m = grid.length;
            int n = grid[ 0 ].length;

            // init
            this.parent = new int[ m*n ];
            this.components = 0;
            
            for( int i = 0; i < m; i++ )
                for( int j = 0; j < n; j++ )
                    if( grid[ i ][ j ] == '1' )
                    {
                        // generate the mapping
                        int id = i * n + j;
                        this.parent[ id ] = id;
                        this.components++;
                    }
        }
        
        public int find( int id )
        {
            return (this.parent[ id ] == id) ? id : find( parent[ id ] );
        }
        
        public void unify( int x, int y )
        {
            int p1 = find( x );
            int p2 = find( y );
            if( p1 != p2 )
            {
                this.parent[ p2 ] = p1;
                // after union two blocks, reduce the counter
                this.components--;
            }
        }
        
        public int getCount()
        {
            return this.components;
        }
    }
}