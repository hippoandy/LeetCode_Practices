package app;

import java.util.*;

class Q54_spiral_matrix
{
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
    // Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Spiral Matrix.
    public List<Integer> spiralOrder(int[][] nums)
    {
        List<Integer> res = new ArrayList<Integer>();
        if( nums == null || nums.length == 0 ) return res;

        int m = nums.length, n = nums[ 0 ].length;

        int r1 = 0, c1 = 0, r2 = m-1, c2 = n-1;

        while( r1 <= r2 && c1 <= c2 )
        {
            int c, r;
            // go right
            for( c = c1; c <= c2; c++ ) res.add( nums[ r1 ][ c ] );
            // go down
            r1++;
            if( r1 > r2 ) break;
            for( r = r1; r <= r2; r++ ) res.add( nums[ r ][ c2 ] );

            // go left
            c2--;
            if( c1 > c2 ) break;
            for( c = c2; c >= c1; c-- ) res.add( nums[ r2 ][ c ] );

            // go up
            r2--;
            if( r1 > r2 ) break;
            for( r = r2; r >= r1; r-- ) res.add( nums[ r ][ c1 ] );
            c1++;
        }
        return res;
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
    // Memory Usage: 34.4 MB, less than 99.52% of Java online submissions for Spiral Matrix.
    // public List<Integer> spiralOrder(int[][] matrix)
    // {
    //     List<Integer> ans = new ArrayList<Integer>();
    //     if( matrix == null ) return ans;
    //     if( matrix.length == 0 ) return ans;
        
    //     // top side:    c from   c1 ...... c2
    //     // right side:  r from r1+1 ...... r2
    //     // bottom side: c from c2-1 ...... c1+1
    //     // left side:   r from   r2 ...... r1+1
    //     int r1 = 0, r2 = matrix.length-1;
    //     int c1 = 0, c2 = matrix[ 0 ].length-1;
        
    //     while( r1 <= r2 && c1 <= c2 )
    //     {
    //         // top side
    //         for( int c = c1; c <= c2; c++ )         ans.add( matrix[ r1 ][ c ] );
    //         // right side
    //         for( int r = r1+1; r <= r2; r++ )       ans.add( matrix[ r ][ c2 ] );
    //         // bottom & left side
    //         if( r1 < r2 && c1 < c2 )
    //         {
    //             // bottom side
    //             for( int c = c2 - 1; c > c1; c-- )  ans.add( matrix[ r2 ][ c ] );
    //             // left side
    //             for( int r = r2; r > r1; r-- )      ans.add( matrix[ r ][ c1 ] );
    //         }
    //         r1++;
    //         r2--;
    //         c1++;
    //         c2--;
    //     }
    //     return ans;
    // }
}