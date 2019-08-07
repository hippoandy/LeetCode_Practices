// ref. https://leetcode.com/problems/knight-probability-in-chessboard/discuss/108214/My-easy-understand-dp-solution

package app;

class Q688_knight_probability_in_chessboard
{
    public double knightProbability(int N, int K, int r, int c)
    {
        if( N <= 0 ) throw null;
        if( K < 0 ) throw null;

        int [][] directions =new int[][]
        {
            {2,1}, {-2,1}, {2,-1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}
        };

        double[][][] dp = new double[ K+1 ][ N ][ N ];
        // dp init
        // the start point's probability is 1 since the knight already chose it
        dp[ 0 ][ r ][ c ] = 1;
        
        for( int k = 1; k <= K; k++ )
            for( int i = 0; i < N; i++ )
            {
                for( int j = 0; j < N; j++ )
                {
                    // 8 possible directions for each grid
                    for( int[] dir: directions )
                    {
                        int x = i + dir[ 0 ], y = j + dir[ 1 ];
                        if( x >= 0 && x < N && y >= 0 && y < N )
                            dp[ k ][ i ][ j ] += (dp[ k-1 ][ x ][ y ] / 8.0);
                    }
                }
            }

        double ans = 0.0;
        for( int i = 0; i < N; i++ )
            for( int j = 0; j < N; j++ )
                ans += dp[ K ][ i ][ j ];
        return ans;
    }
}