package app;

import java.util.*;

class Q593_valid_square
{
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4)
    {
        int[][] p = new int[][]{ p1, p2, p3, p4 };
        // first sort by x-axis, then by y-axis
        Arrays.sort( p, (a, b) -> a[ 0 ] == b[ 0 ] ? a[ 1 ] - b[ 1 ] : a[ 0 ] - b[ 0 ] );
        
        double s1 = dist( p[ 0 ], p[ 1 ] ),
               s2 = dist( p[ 1 ], p[ 3 ] ),
               s3 = dist( p[ 3 ], p[ 2 ] ),
               s4 = dist( p[ 2 ], p[ 0 ] ),
               // diagonal && antidiagonal
               d1 = dist( p[ 0 ], p[ 3 ] ),
               d2 = dist( p[ 1 ], p[ 2 ] );
        return s1 != 0 && s1 == s2 && s2 == s3 && s3 == s4 && d1 == d2;
    }
    
    private double dist( int[] p1, int[] p2 )
    {
        return (p2[ 1 ] - p1[ 1 ]) * (p2[ 1 ] - p1[ 1 ]) +
               (p2[ 0 ] - p1[ 0 ]) * (p2[ 0 ] - p1[ 0 ]);
    }
}