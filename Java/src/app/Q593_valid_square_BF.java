package app;

class Q593_valid_square_BF 
{
    // brute force
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4)
    {
        int[][] p = new int[][]{ p1, p2, p3, p4 };
        return backtracking( p, 0 );
    }
    
    // create all the possible states
    private boolean backtracking( int[][] p, int start )
    {
        if( start == 4 ) return check( p[ 0 ], p[ 1 ], p[ 2 ], p[ 3 ] );
        else
        {
            for( int i = start; i < p.length; i++ )
            {
                // swap the current idx
                swap( p, i, start );
                // backtracking
                if( backtracking( p, i+1 ) ) return true;
                // restore to gen next state
                swap( p, i, start );
            }
        }
        return false;
    }
    
    private void swap( int[][] p, int a, int b )
    {
        int[] tmp = p[ a ];
        p[ a ] = p[ b ];
        p[ b ] = tmp;
    }
    
    private boolean check( int[] p1, int[] p2, int[] p3, int[] p4 )
    {
        double s1 = dist( p1, p2 ),
               s2 = dist( p2, p3 ),
               s3 = dist( p3, p4 ),
               s4 = dist( p4, p1 ),
               // diagonal && antidiagonal
               d1 = dist( p1, p3 ),
               d2 = dist( p2, p4 );
        return s1 != 0 && s1 == s2 && s2 == s3 && s3 == s4 && d1 == d2;
    }
    
    private double dist( int[] p1, int[] p2 )
    {
        return (p2[ 1 ] - p1[ 1 ]) * (p2[ 1 ] - p1[ 1 ]) +
               (p2[ 0 ] - p1[ 0 ]) * (p2[ 0 ] - p1[ 0 ]);
    }
}