package app;

// Runtime: 1 ms, faster than 94.39% of Java online submissions for Battleships in a Board.
// Memory Usage: 42.7 MB, less than 61.59% of Java online submissions for Battleships in a Board.
class Q419_battleships_in_a_board_DFS
{
    int m, n;
    public int countBattleships(char[][] board)
    {
        if( board == null ) return 0;
        m = board.length;
        if( m == 0 ) return 0;
        n = board[ 0 ].length;
        if( n == 0 ) return 0;

        int count = 0;
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
                if( board[ i ][ j ] == 'X' )
                {
                    count++;
                    dfs( board, i, j );
                }
        return count;
    }
    
    private void dfs( char[][] board, int i, int j )
    {
        if( board[ i ][ j ] == '.' ) return;
        if( board[ i ][ j ] == 'V' ) return;
        
        board[ i ][ j ] = 'V';

        if( i > 0 ) dfs( board, i-1, j );
        if( i < m-1 ) dfs( board, i+1, j );
        if( j > 0 ) dfs( board, i, j-1 );
        if( j < n-1 ) dfs( board, i, j+1 );
    }
}