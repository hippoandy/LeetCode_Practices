package app;

import java.util.*;

// Runtime: 3 ms, faster than 67.56% of Java online submissions for Index Pairs of a String.
// Memory Usage: 36.3 MB, less than 50.00% of Java online submissions for Index Pairs of a String.
class Q1065_idx_pairs_of_a_str
{
    public int[][] indexPairs(String text, String[] words)
    {
        // build the trie;
        TrieNode root = new TrieNode();
        for( String w: words )
        {
            TrieNode cur = root;
            for( int i = 0; i < w.length(); i++ )
            {
                int idx = (int) (w.charAt( i ) - 'a');
                if( !cur.contains( idx ) ) cur.put( idx, new TrieNode() );
                cur = cur.get( idx );
            }
            cur.setEnd();
        }
        
        List<int[]> ans = new LinkedList<int[]>();
        
        TrieNode cur = root;
        int N = text.length();
        for( int i = 0; i < N; i++ )
        {
            int idx = (int) (text.charAt( i ) - 'a'), j = i;
            while( cur.contains( idx ) )
            {
                cur = cur.get( idx );
                if( cur.isEnd() ) ans.add( new int[]{ i, j } );
                if( ++j == N ) break;
                idx = (int) (text.charAt( j ) - 'a');
            }
            // make sure to restore to init state
            cur = root;
        }
        return ans.toArray( new int[ ans.size() ][ 2 ] );
    }
    
    private class TrieNode
    {
        private TrieNode[] child;
        private boolean isEnd;
        
        public TrieNode()
        {
            this.child = new TrieNode[ 26 ];
            this.isEnd = false;
        }
        
        public TrieNode get( int idx )
        {
            return this.child[ idx ];
        }
        
        public void put( int idx, TrieNode n )
        {
            this.child[ idx ] = n;
        }
        
        public boolean contains( int idx )
        {
            if( this.child[ idx ] != null ) return true;
            return false;
        }
        
        public void setEnd()
        {
            this.isEnd = true;
        }
        
        public boolean isEnd()
        { return this.isEnd; }
    }
}