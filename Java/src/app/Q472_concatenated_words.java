// ref. https://leetcode.com/problems/concatenated-words/discuss/95644/102ms-java-Trie-%2B-DFS-solution.-With-explanation-easy-to-understand.

package app;

import java.util.*;

class Q472_concatenated_words
{
    public List<String> findAllConcatenatedWordsInADict(String[] words)
    {
        List<String> res = new ArrayList<String>();
        if( words == null || words.length == 0 ) return res;
        
        // build the trie
        TrieNode root = new TrieNode();
        for( String word: words )
        {
            // skip the empty word
            if( word.length() == 0 ) continue;

            TrieNode ptr = root;
            for( char c: word.toCharArray() )
            {
                int idx = (int) (c - 'a');
                if( ptr.child[ idx ] == null ) ptr.child[ idx ] = new TrieNode();
                ptr = ptr.child[ idx ];
            }
            ptr.isWord = true;
            ptr.word = word;
        }
        
        // test a word if it is a concatenated one
        for( String word: words )
        {
            // skip the empty word
            if( word.length() == 0 ) continue;
            // perform dfs to find the sub-word
            if( dfs( word.toCharArray(), 0, root, 0 ) ) res.add( word );
        }
        return res;
    }
    
    // count: stores how many words form the current word
    private boolean dfs( char[] word, int start, TrieNode root, int count )
    {
        TrieNode ptr = root;
        int n = word.length;
        
        for( int i = start; i < n; i++ )
        {
            int idx = word[ i ] - 'a';
            if( ptr.child[ idx ] == null ) return false;
            
            // found a sub-word
            if( ptr.child[ idx ].isWord )
            {
                // reaches the end of the word
                if( i == n-1 ) return count >= 1;
                // check the remaining part
                // a word should always start at root
                // remember to skip the currnt idx
                if( dfs( word, i+1, root, count + 1 ) ) return true;
            }
            // move the pointer
            ptr = ptr.child[ idx ];
        }
        return false;
    }
    
    class TrieNode
    {
        TrieNode[] child;
        boolean isWord;
        String word;
        
        public TrieNode()
        {
            this.child = new TrieNode[ 26 ];
        }
    }
}