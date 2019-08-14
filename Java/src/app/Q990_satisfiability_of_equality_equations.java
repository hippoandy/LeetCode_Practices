// ref. https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/234486/JavaC%2B%2BPython-Easy-Union-Find

package app;

class Q990_satisfiability_of_equality_equations
{
    public boolean equationsPossible(String[] equations)
    {
        DSU dsu = new DSU();
        
        for( String e: equations )
            if( e.contains( "==" ) )
                dsu.unify( (e.charAt( 0 ) - 'a'), (e.charAt( 3 ) - 'a') );
        for( String e: equations )
            if( e.contains( "!=" ) && dsu.equivalent( (e.charAt( 0 ) - 'a'), (e.charAt( 3 ) - 'a') ) )
                return false;
        return true;
    }
    
    private class DSU
    {
        private int[] parent;
        public DSU()
        {
            this.parent = new int[ 26 ];
            for( int i = 0; i < this.parent.length; i++ )
                this.parent[ i ] = i;
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
            this.parent[ find( y ) ] = find( x );
        }
        
        public boolean equivalent( int x, int y )
        {
            return find( x ) == find( y );
        }
    }
}