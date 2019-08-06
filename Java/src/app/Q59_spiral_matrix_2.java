package app;

class Q59_spiral_matrix_2
{
    public int[][] generateMatrix(int n)
    {
        if( n < 0 ) throw null;
        if( n == 0 ) return new int[ 0 ][ 0 ];
        
        int[][] ans = new int[ n ][ n ];
        
        // top side:    c from   c1 ...... c2
        // right side:  r from r1+1 ...... r2
        // bottom side: c from c2-1 ...... c1+1
        // left side:   r from   r2 ...... r1+1
        int r1 = 0, r2 = n-1;
        int c1 = 0, c2 = n-1;
        
        int val = 0;
        while( r1 <= r2 && c1 <= c2 )
        {
            // top side
            for( int c = c1; c <= c2; c++ )         ans[ r1 ][ c ] = ++val;
            // right side
            for( int r = r1+1; r <= r2; r++ )       ans[ r ][ c2 ] = ++val;
            // bottom & left side
            if( r1 < r2 && c1 < c2 )
            {
                // bottom side
                for( int c = c2 - 1; c > c1; c-- )  ans[ r2 ][ c ] = ++val;
                // left side
                for( int r = r2; r > r1; r-- )      ans[ r ][ c1 ] = ++val;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        
        return ans;
    }
}