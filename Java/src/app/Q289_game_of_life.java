package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
// Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Game of Life.
class Q289_game_of_life
{
    public void gameOfLife(int[][] board)
    {
        if( board == null ) return;
        int m = board.length;
        if( m == 0 ) return;
        int n = board[ 0 ].length;
        if( n == 0 ) return;

        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
            {
                int c = board[ i ][ j ];
                // count how many neighbors
                int livingNei = 0;
                if( i > 0 )
                    livingNei = (board[ i-1 ][ j ] == 1 || board[ i-1 ][ j ] == -1) ? livingNei+1 : livingNei;
                if( j > 0 )
                    livingNei = (board[ i ][ j-1 ] == 1 || board[ i ][ j-1 ] == -1) ? livingNei+1 : livingNei;
                if( i < m-1 )
                    livingNei = (board[ i+1 ][ j ] == 1 || board[ i+1 ][ j ] == -1) ? livingNei+1 : livingNei;
                if( j < n-1 )
                    livingNei = (board[ i ][ j+1 ] == 1 || board[ i ][ j+1 ] == -1) ? livingNei+1 : livingNei;
                if( i > 0 && j > 0 )
                    livingNei = (board[ i-1 ][ j-1 ] == 1 || board[ i-1 ][ j-1 ] == -1) ? livingNei+1 : livingNei;
                if( i < m-1 && j < n-1 )
                    livingNei = (board[ i+1 ][ j+1 ] == 1 || board[ i+1 ][ j+1 ] == -1) ? livingNei+1 : livingNei;
                if( i < m-1 && j > 0 )
                    livingNei = (board[ i+1 ][ j-1 ] == 1 || board[ i+1 ][ j-1 ] == -1) ? livingNei+1 : livingNei;
                if( i > 0 && j < n-1 )
                    livingNei = (board[ i-1 ][ j+1 ] == 1 || board[ i-1 ][ j+1 ] == -1) ? livingNei+1 : livingNei;

                switch( c )
                {
                    case 1:
                        // case 1: under-population
                        if( livingNei < 2 ) board[ i ][ j ] = -1;
                        // case 3: over-population
                        if( livingNei > 3 ) board[ i ][ j ] = -1;
                        break;
                    case 0:
                        if( livingNei == 3 ) board[ i ][ j ] = 2;
                        break;
                }
            }
        // restore the mark
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
            {
                if( board[ i ][ j ] == -1 ) board[ i ][ j ] = 0;
                if( board[ i ][ j ] ==  2 ) board[ i ][ j ] = 1;
            }
    }
}