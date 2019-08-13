// ref. https://leetcode.com/problems/number-of-islands-ii/discuss/75470/Easiest-Java-Solution-with-Explanations

package app;

import java.util.*;

// Runtime: 11 ms, faster than 63.54% of Java online submissions for Number of Islands II.
// Memory Usage: 53.5 MB, less than 100.00% of Java online submissions for Number of Islands II.
class Q305_numof_islands_2
{
    int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public List<Integer> numIslands2(int m, int n, int[][] positions)
    {
        List<Integer> ans = new ArrayList<Integer>();
        DSU dsu = new DSU( m, n );
        for( int[] p: positions )
        {
            int root = p[ 0 ] * n + p[ 1 ];
            // add island
            dsu.setParent( root );
            // union 4 directions
            for( int[] dir: dirs )
            {
                int x = p[ 0 ] + dir[ 0 ];
                int y = p[ 1 ] + dir[ 1 ];
                int idx = x * n + y;
                if( x < 0 || x >= m || y < 0 || y >= n || !dsu.isValid( idx ) ) continue;
                // connect the island (grid is valid!)
                dsu.unify( root, idx );
            }
            ans.add( dsu.getCount() );
        }
        return ans;
    }
    
    private class DSU
    {
        private int[] parent;
        private int[] rank;
        private int components;
        
        public DSU( int m, int n )
        {
            this.parent = new int[ m*n ];
            this.rank = new int[ m*n ];
            this.components = 0;
            
            Arrays.fill( this.parent, -1 );
            Arrays.fill( this.rank, 0 );
        }
        
        public boolean isValid( int i )
        {
            return parent[ i ] != -1;
        }
        
        public void setParent( int i )
        {
            // prevent duplicate points input
            if( !isValid( i ) )
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
            int p1 = find( x ), p2 = find( y );
            if( p1 != p2 )
            {
                if( this.rank[ p1 ] > this.rank[ p2 ] ) this.parent[ p2 ] = p1;
                else if( this.rank[ p1 ] < this.rank[ p2 ] ) this.parent[ p1 ] = p2;
                else
                {
                    // if has same ranking, increment p1's rank
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