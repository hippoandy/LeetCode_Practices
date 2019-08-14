// ref. https://leetcode.com/problems/rotated-digits/discuss/117975/Java-dp-solution-9ms

package app;

class Q788_rotated_digits_DP
{
    public int rotatedDigits(int N)
    {
        if( N < 1 ) throw new IllegalArgumentException( "N in range [1, 10000]" );
        
        int[] dp = new int[ N+1 ];
        dp[ 0 ] = 1;
        // dp[ i ] = 0: 3, 4 ,7
        // dp[ i ] = 1: 0, 1, 8
        // dp[ i ] = 2: 2, 5, 6, 9
        int count = 0;
        for( int i = 1; i <= N; i++ )
        {
            if( i < 10 )
            {
                switch( i )
                {
                    case 3:
                    case 4:
                    case 7: dp[ i ] = 0; break;
                    case 0:
                    case 1:
                    case 8: dp[ i ] = 1; break;
                    case 2:
                    case 5:
                    case 6:
                    case 9: dp[ i ] = 2; count++; break;
                }
            }
            else
            {
                int a = dp[ i / 10 ], b = dp[ i % 10 ];
                if( a == 1 && b == 1 ) dp[ i ] = 1;
                else if( a >= 1 && b >= 1 )
                {
                    dp[ i ] = 2;
                    count++;
                }
            }
        }
        return count;
    }
}