package app;

class Q633_sum_of_square_nums
{
    public boolean judgeSquareSum(int c)
    {
        // pow( a, 2 ) + pow( b, 2 ) = c => c - pow( a, 2 ) = pow( b, 2 )
        // a * a <= c for case c == 0
        for( long a = 0; a * a <= c; a++ )
        {
            long b_square = (long) c - (long) Math.pow( a, 2 ) ;
            if( binSearch( 0, b_square, b_square ) ) return true;
        }
        return false;
    }
    
    private boolean binSearch( long left, long right, long num )
    {
        if( left > right ) return false;
        long mid = left + (right - left) / 2;
        // if found, mid is b
        if( mid * mid == num ) return true;
        if( mid * mid > num )
            return binSearch( left, mid - 1, num );
        else
            return binSearch( mid + 1, right, num );
    }
}