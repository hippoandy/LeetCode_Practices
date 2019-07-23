package app;

import java.util.*;

// Runtime: 3 ms, faster than 15.93% of Java online submissions for Reshape the Matrix.
// Memory Usage: 39.9 MB, less than 76.16% of Java online submissions for Reshape the Matrix.
class Q566_reshape_matrix_QUEUE
{
    public int[][] matrixReshape(int[][] nums, int r, int c)
    {
        if( nums == null ) return nums;
        if( nums.length == 0 ) return nums;
        
        int m = nums.length, n = nums[ 0 ].length;
        if( r * c != m * n ) return nums;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
                queue.offer( nums[ i ][ j ] );
        
        int[][] ans = new int[ r ][ c ];
        for( int i = 0; i < r; i++ )
            for( int j = 0; j < c; j++ )
                ans[ i ][ j ] = queue.remove();
        
        return ans;
    }
}