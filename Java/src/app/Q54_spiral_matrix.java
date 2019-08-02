package app;

import java.util.*;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
// Memory Usage: 34.4 MB, less than 99.52% of Java online submissions for Spiral Matrix.
class Q54_spiral_matrix
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> ans = new ArrayList<Integer>();
        if( matrix == null ) return ans;
        if( matrix.length == 0 ) return ans;
        
        // top side:    c from   c1 ...... c2
        // right side:  r from r1+1 ...... r2
        // bottom side: c from c2-1 ...... c1+1
        // left side:   r from   r2 ...... r1+1
        int r1 = 0, r2 = matrix.length-1;
        int c1 = 0, c2 = matrix[ 0 ].length-1;
        
        while( r1 <= r2 && c1 <= c2 )
        {
            // top side
            for( int c = c1; c <= c2; c++ )         ans.add( matrix[ r1 ][ c ] );
            // right side
            for( int r = r1+1; r <= r2; r++ )       ans.add( matrix[ r ][ c2 ] );
            // bottom & left side
            if( r1 < r2 && c1 < c2 )
            {
                // bottom side
                for( int c = c2 - 1; c > c1; c-- )  ans.add( matrix[ r2 ][ c ] );
                // left side
                for( int r = r2; r > r1; r-- )      ans.add( matrix[ r ][ c1 ] );
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}