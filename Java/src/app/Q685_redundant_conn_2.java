// ref. https://leetcode.com/problems/redundant-connection-ii/discuss/278105/topic
// ref. https://leetcode.com/problems/redundant-connection-ii/discuss/112569/Easiest-understanding-Java-Solution-using-Union-Find-O(n).

package app;

class Q685_redundant_conn_2
{
    public int[] findRedundantDirectedConnection(int[][] edges)
    {
        int[] candi1 = null, candi2 = null;
        DSU dsu = new DSU( edges.length );
        for( int[] e: edges )
        {
            int rootu = dsu.find( e[ 0 ] ),
                rootv = dsu.find( e[ 1 ] );
            
            // case 2. record the last edge which results in "multiple parents" issue
            if( rootv != e[ 1 ] )
                candi1 = e;
            // case 3. record last edge which results in "cycle" issue, if any
			else if( rootu == rootv )
                candi2 = e;
            else
                dsu.unify( e[ 0 ], e[ 1 ] );
        }

        // if there is only one issue, return this one.
        if( candi1 == null ) return candi2; 
        if( candi2 == null ) return candi1;
        
        /* if both issues present, then the ans should be
           the first edge which results in "multiple parents" issue
           
           the reason is, when an issue happens, we skip the "union" process.
           
		   therefore, if both issues happen,
           it means the incorrent edge which results in "multiple parents" was ignored.
         */
        for( int[] e : edges ) if( e[ 1 ] == candi1[ 1 ] ) return e;
        
        throw null;
    }
    
    private class DSU
    {
        int[] parent;
        public DSU( int n )
        {
            this.parent = new int[ n+1 ];
            for( int i = 1; i <= n; i++ )
                this.parent[ i ] = i;
        }

        public int find( int id )
        {
            return id == this.parent[ id ] ? id : (this.parent[ id ] = find( this.parent[ id ] ));
        }

        public void unify( int x, int y )
        {
            this.parent[ find( y ) ] = find( x );
        }
    }
}