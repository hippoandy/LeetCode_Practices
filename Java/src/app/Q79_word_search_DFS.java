package app;

class Q79_word_search_DFS
{
    int m, n;
    public boolean exist(char[][] board, String word)
    {
        if( board == null || board.length == 0 ) return false;
        
        m = board.length;
        n = board[ 0 ].length;
        
        // find the start point
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
                if( board[ i ][ j ] == word.charAt( 0 ) )
                    if( helper( board, word, 0, i, j ) )
                        return true;
        return false;
    }
    
    private boolean helper( char[][] b, String word, int idx, int i, int j )
    {
        // for corner case [[A]] find "A"
        if( idx == word.length() ) return true;

        if( i >= m || i < 0 || j >= n || j < 0 || b[ i ][ j ] != word.charAt( idx ) ) return false;

        char cur = b[ i ][ j ];
        
        // mark visited
        b[ i ][ j ] = '#';
        boolean res = helper( b, word, idx+1, i+1, j ) ||
                      helper( b, word, idx+1, i, j+1 ) ||
                      helper( b, word, idx+1, i-1, j ) ||
                      helper( b, word, idx+1, i, j-1 );
        b[ i ][ j ] = cur;
        return res;
    }
}