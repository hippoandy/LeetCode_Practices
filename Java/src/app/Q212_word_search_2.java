// ref. https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)

package app;

import java.util.*;

class Q212_word_search_2
{
    int m, n;
    public List<String> findWords(char[][] board, String[] words)
    {
        List<String> ans = new ArrayList<String>();
        if( board == null ) return ans;
        m = board.length;
        if( m == 0 ) return ans;
        n = board[ 0 ].length;
        if( n == 0 ) return ans;
        
        TrieNode root = buildTrie( words );
        
        // traverse the board
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
                dfs( board, i, j, root, ans );
        return ans;
    }
    
    private void dfs( char[][] board, int i, int j, TrieNode cur, List<String> ans )
    {
        char c = board[ i ][ j ];
        // reduce the amount for dfs recursive calls
        if( c == '#' || !cur.containsKey( c ) ) return;
        cur = cur.get( c );

        // found a word
        if( !cur.getWord().equals( "" ) )
        {
            ans.add( cur.getWord() );
            cur.setWord( "" );          // dedup
        }

        // mark the current location
        board[ i ][ j ] = '#';
        // traverse 4 directions;
        if( i > 0 )     dfs( board, i - 1, j, cur, ans ); // up
        if( i < m - 1 ) dfs( board, i + 1, j, cur, ans ); // down
        if( j > 0 )     dfs( board, i, j - 1, cur ,ans ); // left
        if( j < n - 1 ) dfs( board, i, j + 1, cur, ans ); // right
        // restore
        board[ i ][ j ] = c;
    }
    
    private TrieNode buildTrie( String[] words )
    {
        TrieNode root = new TrieNode();
        for( String w: words )
        {
            TrieNode ptr = root;
            for( int i = 0; i < w.length(); i++ )
            {
                char c = w.charAt( i );
                if( !ptr.containsKey( c ) )
                    ptr.put( c, new TrieNode() );
                ptr = ptr.get( c );
            }
            ptr.setWord( w );
        }
        return root;
    }
    
    private class TrieNode
    {
        private final int R = 26;
        private TrieNode[] links;
        private String word;
        
        public TrieNode()
        {
            this.links = new TrieNode[ R ];
            this.word = "";
        }
        
        public void put( char c, TrieNode n )
        {
            this.links[ c - 'a' ] = n;
        }
        
        public TrieNode get( char c )
        {
            return links[ c - 'a' ];
        }
        
        public boolean containsKey( char c )
        {
            return this.links[ c - 'a' ] != null;
        }
        
        public void setWord( String word )
        {
            this.word = word;
        }
        
        public String getWord()
        {
            return this.word;
        }
    }
}