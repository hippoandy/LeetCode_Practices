package app;

class Q1007_min_domino_rotations_for_equal_row
{
    public int minDominoRotations(int[] A, int[] B)
    {
        int min = Integer.MAX_VALUE, n = A.length;
        
        for( int i = 0, tar = A[ 0 ], a = 0, b = 0; i < n && (A[ i ] == tar || B[ i ] == tar); i++ )
        {
            if( A[ i ] != tar ) a++;
            if( B[ i ] != tar ) b++;
            
            if( i == n-1 )
            {
                int res = Math.min( a, b );
                min = (res < min) ? res : min;
            }
        }
        
        for( int i = 0, tar = B[ 0 ], a = 0, b = 0; i < n && (A[ i ] == tar || B[ i ] == tar); i++ )
        {
            if( A[ i ] != tar ) a++;
            if( B[ i ] != tar ) b++;
            
            if( i == n-1 )
            {
                int res = Math.min( a, b );
                min = (res < min) ? res : min;
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}