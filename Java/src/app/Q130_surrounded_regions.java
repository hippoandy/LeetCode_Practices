// ref. https://leetcode.com/problems/surrounded-regions/discuss/41633/Java-DFS-%2B-boundary-cell-turning-solution-simple-and-clean-code-commented.

package app;

class Q130_surrounded_regions
{
    int m, n;
    public void solve(char[][] board)
    {
        if( board == null ) return;
        m = board.length;
        if( m <= 2 ) return;
        n = board[ 0 ].length;
        if( n <= 2 ) return;

        // every 'O' at the boundary is not able to be surrounded
        // start at the boundary
        for( int i = 0; i < m; i++ )
        {
            // first column and last column
            if( board[ i ][ 0 ]   == 'O' ) dfs( board, i, 0 );
            if( board[ i ][ n-1 ] == 'O' ) dfs( board, i, n-1 );
        }
        for( int j = 0; j < n; j++ )
        {
            // first row and last row
            if( board[ 0 ][ j ]   == 'O' ) dfs( board, 0, j );
            if( board[ m-1 ][ j ] == 'O' ) dfs( board, m-1, j );
        }
        
        // gen the result
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
            {
                if( board[ i ][ j ] == 'O' ) board[ i ][ j ] = 'X';
                else if( board[ i ][ j ] == '*' ) board[ i ][ j ] = 'O';
            }
    }
    
    // version 2: Accepted!!!
    // reduced the amount of recursive calls to prevent stackOverFlow
    private void dfs( char[][] board, int i, int j )
    {
        // out of bound
        if( i < 0 || i > m - 1 || j < 0 || j > n - 1) return;
        // mark the 'O'
        if( board[ i ][ j ] == 'O' ) board[ i ][ j ] = '*';
        
        // trace 4 directions
        // up
        if( i > 1   && board[ i-1 ][ j ] == 'O' ) dfs( board, i-1, j );
        // down
        if( i < m-2 && board[ i+1 ][ j ] == 'O' ) dfs( board, i+1, j );
        // left
        if( j > 1   && board[ i ][ j-1 ] == 'O' ) dfs( board, i, j-1 );
        // right
        if( j < n-2 && board[ i ][ j+1 ] == 'O' ) dfs( board, i, j+1 );
    }
    
//     // version 1: stackOverFlow!!!
//     private void dfs( char[][] board, int i, int j )
//     {
//         // out of bound
//         if( i < 0 || i > m - 1 || j < 0 || j > n - 1) return;
//         // mark the 'O'
//         if( board[ i ][ j ] == 'O' ) board[ i ][ j ] = '*';
        
//         // trace 4 directions
//         // up
//         dfs( board, i-1, j );
//         // down
//         dfs( board, i+1, j );
//         // left
//         dfs( board, i, j-1 );
//         // right
//         dfs( board, i, j+1 );
//     }
}