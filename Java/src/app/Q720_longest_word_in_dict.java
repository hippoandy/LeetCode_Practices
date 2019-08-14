package app;

import java.util.*;

// Runtime: 19 ms, faster than 37.32% of Java online submissions for Longest Word in Dictionary.
// Memory Usage: 38.2 MB, less than 81.25% of Java online submissions for Longest Word in Dictionary.
class Q720_longest_word_in_dict
{
    public String longestWord(String[] words)
    {
        // sort the array by string length
        Arrays.sort( words, new Comparator<String>()
        {   @Override
            public int compare( String a, String b )
            {   // if same length, sort by alphabetical order
                // also, the problem requires "return the longest word with the smallest lexicographical order"
                if( a.length() == b.length() ) return a.compareTo( b );
                return a.length() - b.length();
            }
        });
        
        TrieNode root = new TrieNode();
        
        int max = 0;
        String ans = "";
        
        for( String w: words )
        {
            TrieNode cur = root;
            int pass = 0,       // record how many word on the same path
                n = w.length();
            for( int i = 0; i < n; i++ )
            {
                int idx = (int) (w.charAt( i ) - 'a');
                if( cur.child[ idx ] == null ) cur.child[ idx ] = new TrieNode();
                else
                    if( cur.child[ idx ].isEnd ) pass++;
                cur = cur.child[ idx ];
            }
            cur.isEnd = true;
            if( pass == n-1 && n > max )
            {
                max = n;
                ans = w;
            }
        }
        return ans;
    }
    
    private class TrieNode
    {
        TrieNode[] child;
        boolean isEnd;
        
        public TrieNode()
        {
            this.child = new TrieNode[ 26 ];
            this.isEnd = false;
        }
    }
}