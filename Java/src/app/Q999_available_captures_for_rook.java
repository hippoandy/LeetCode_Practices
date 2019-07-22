// ref. https://leetcode.com/problems/available-captures-for-rook/discuss/339544/Simple-c%2B%2B-solution

package app;

class Q999_available_captures_for_rook
{
    public int numRookCaptures(char[][] board)
    {
        if( board == null )     return 0;
        if( board.length == 0 ) return 0;
        
        // find the rook
        int x = 0, y = 0;
        for( int i = 0; i < 8; i++ )
            for( int j = 0; j < 8; j++ )
            {
                if( board[ i ][ j ] == 'R' )
                {
                    x = i;
                    y = j;
                    break;
                }
            }

        // search for 4 directions
        return search( board, x, y, -1, 0 ) + search( board, x, y, 1, 0 ) +
               search( board, x, y, 0, -1 ) + search( board, x, y, 0, 1 );
    }
    
    private int search( char[][] board, int i, int j, int x, int y )
    {
        if( (i + x) < 0 || (i + x) > 7 || (j + y) < 0 || (j + y) > 7 ) return 0;
        // check what is found
        if( board[ i + x ][ j + y ] == 'p' ) return 1;
        if( board[ i + x ][ j + y ] == 'B' ) return 0;
        
        return search( board, i+x, j+y, x, y );
    }
}