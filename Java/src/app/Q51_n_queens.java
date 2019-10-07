// ref. https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
// ref. http://www2.csie.ntnu.edu.tw/~u91029/Backtracking.html#6
// ref. Q52

package app;

import java.util.*;

// Runtime: 3 ms, faster than 74.53% of Java online submissions for N-Queens.
// Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for N-Queens.
class Q51_n_queens
{
    private void appendSolution( List<List<String>> res, char[][] board )
    {
        List<String> cur = new ArrayList<String>();
        for( char[] row: board ) cur.add( new String( row ) );
        res.add( cur );
    }
    
    private boolean isSafe( char[][] board, int N, int r, int c )
    {
         // check current row
         for( int i = 0; i < c; i++ )
            if( board[ r ][ i ] == 'Q' )
                return false;
        // check upper diagonal
        for( int i = r, j = c; i >= 0 && j >= 0; i--, j-- )
            if( board[ i ][ j ] == 'Q' )
                return false;
        // check lower diagonal
        for( int i = r, j = c; i < N && j >= 0; i++, j-- )
            if( board[ i ][ j ] == 'Q' )
                return false;
        return true;
    }
    
    private void backtracking( List<List<String>> res, char[][] board, int n, int col )
    {
        if( col == n )
        {
            appendSolution( res, board );
            return;
        }
        
        for( int i = 0; i < n; i++ )
            if( isSafe( board, n, i, col ) )
            {
                // place the queen
                board[ i ][ col ] = 'Q';
                backtracking( res, board, n, col+1 );
                // restore
                board[ i ][ col ] = '.';
            }
    }
    
    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> res = new ArrayList<List<String>>();
        
        char[][] board = new char[ n ][ n ];
        // init
        for( int i = 0; i < n; i++ ) Arrays.fill( board[ i ], '.' );
        
        backtracking( res, board, n, 0 );

        return res;
    }
}