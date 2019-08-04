// ref. https://leetcode.com/problems/minesweeper/discuss/99841/Straight-forward-Java-solution

package app;

class Q529_minesweeper
{
    int m, n;
    public char[][] updateBoard(char[][] board, int[] click)
    {
        if( board == null ) return board;
        m = board.length;
        if( m == 0 ) return board;
        n = board[ 0 ].length;
        if( n == 0 ) return board;
        
        int i = click[ 0 ], j = click[ 1 ];
        if( board[ i ][ j ] == 'M' )
        {
            board[ i ][ j ] = 'X';
            return board;
        }
        else
            dfs( board, i, j );
        return board;
    }

    int[] di = {-1, 0, 1, -1, 1, 0, 1, -1};
    int[] dj = {-1, 1, 1, 0, -1, -1, 0, 1};
    private void dfs( char[][] b, int i, int j )
    {
        if( i < 0 || i >= m || j < 0 || j >= n || b[ i ][ j ] != 'E' ) return;

        int mines = 0;
        // check the surrounding
        for( int x = 0; x < 8; x++ )
        {
            int ni = i + di[ x ], nj = j + dj[ x ];
            if( ni < 0 || ni >= m || nj < 0 || nj >= n ) continue;
            if( b[ ni ][ nj ] == 'M' || b[ ni ][ nj ] == 'X')
                mines++;
        }
        
        if( mines > 0 ) b[ i ][ j ] = (char) (mines + '0');
        else
        {
            b[ i ][ j ] = 'B';
            for( int x = 0; x < 8; x++ )
            {
                int ni = i + di[ x ], nj = j + dj[ x ];
                dfs( b, ni, nj );
            }
        }
    }
}