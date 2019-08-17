// ref. https://leetcode.com/problems/minimum-path-sum/discuss/23471/DP-with-O(N*N)-space-complexity

package app;

class Q64_minimum_path_sum
{
    public int minPathSum(int[][] grid)
    {
        int m = grid.length, n = grid[ 0 ].length;

        // initialization
        for( int i = 1; i < m; i++ )
            // go straight down
            grid[ i ][ 0 ] += grid[ i - 1 ][ 0 ];
        for( int i = 1; i < n; i++ )
            // go straight right
            grid[ 0 ][ i ] += grid[ 0 ][ i - 1 ];

        for( int i = 1; i < m; i++ )
            for( int j = 1; j < n; j++ )
                // only 2 direction to consider since from top left to bottom right,
                // only need to consider going right or down
                grid[ i ][ j ] += Math.min( grid[ i - 1 ][ j ], grid[ i ][ j - 1 ] );
        return grid[ m-1 ][ n-1 ];
    }
}