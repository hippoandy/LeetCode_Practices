// ref. https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
// ref. http://www2.csie.ntnu.edu.tw/~u91029/Backtracking.html#6
// ref. Q51

package app;

class Q52_n_queens_2
{
    private boolean isSafe( int[][] board, int n, int r, int c )
    {
        // check this row
        for( int i = 0; i < c; i++ )
            if( board[ r ][ i ] == 1 )
                return false;
        // check upper diagonal
        for( int i = r, j = c; i >= 0 && j >= 0; i--, j-- )
            if( board[ i ][ j ] == 1 )
                return false;
        // check lower diagonal
        for( int i = r, j = c; i < n && j >= 0; i++, j-- )
            if( board[ i ][ j ] == 1 )
                return false;
        return true;
    }
    
    private int backtracking( int[][] board, int n, int col )
    {
        if( col == n ) return 1;
        
        int count = 0;
        for( int i = 0; i < n; i++ )
            if( isSafe( board, n, i, col ) )
            {
                // place the queen
                board[ i ][ col ] = 1;
                count += backtracking( board, n, col+1 );
                // restore
                board[ i ][ col ] = 0;
            }
        return count;
    }

    public int totalNQueens(int n)
    {
        int[][] board = new int[ n ][ n ];
        return backtracking( board, n, 0 );
    }
}