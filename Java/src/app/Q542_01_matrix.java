// ref. https://leetcode.com/problems/01-matrix/discuss/101021/Java-Solution-BFS

package app;

import java.util.*;

class Q542_01_matrix
{
    public int[][] updateMatrix(int[][] matrix)
    {
        if( matrix == null || matrix.length == 0 ) throw new IllegalArgumentException( "The maze is null!" );
        int m = matrix.length, n = matrix[ 0 ].length;
        
        Queue<int[]> q = new LinkedList<int[]>();
        
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
            {
                // record all the coordinates with value '0'
                if( matrix[ i ][ j ] == 0 ) q.offer( new int[]{ i, j } );
                // marked unreached
                else matrix[ i ][ j ] = Integer.MAX_VALUE;
            }
        
        // perform BFS
        int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        while( !q.isEmpty() )
        {
            int[] pos = q.remove();
            for( int[] dir: dirs )
            {
                int x = pos[ 0 ] + dir[ 0 ], y = pos[ 1 ] + dir[ 1 ];
                if(
                    x < 0 || x >= m || y < 0 || y >= n ||
                    matrix[ x ][ y ] <= matrix[ pos[ 0 ] ][ pos[ 1 ] ] + 1
                ) continue;
                
                q.offer( new int[]{ x, y } );
                matrix[ x ][ y ] = matrix[ pos[ 0 ] ][ pos[ 1 ] ] + 1;
            }
        }
        return matrix;
    }
}