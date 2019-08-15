package app;

import java.util.*;

class Q648_replace_words
{
    public String replaceWords(List<String> dict, String sentence)
    {
        // build the try;
        TrieNode root = new TrieNode();
        for( String d: dict )
        {
            TrieNode cur = root;
            for( int i = 0; i < d.length(); i++ )
            {
                int idx = (int) (d.charAt( i ) - 'a');
                if( cur.child[ idx ] == null ) cur.child[ idx ] = new TrieNode();
                cur = cur.child[ idx ];
            }
            cur.isEnd = true;
            cur.word = d;
        }

        // // Runtime: 21 ms, faster than 43.69% of Java online submissions for Replace Words.
        // // Memory Usage: 53.3 MB, less than 75.00% of Java online submissions for Replace Words.
        // // could be multiple spaces!
        // String[] words = sentence.split( "\\s+" );
        // for( int i = 0; i < words.length; i++ )
        // {
        //     TrieNode cur = root;
        //     String w = words[ i ];
        //     // if the current head of word doesn't even a root, jump to next word in the sentence
        //     if( cur.child[ w.charAt( 0 ) - 'a' ] == null ) continue;
            
        //     // find the shortest root and replace the word
        //     int j = 0;
        //     while( j < w.length() && cur.child[ w.charAt( j ) - 'a' ] != null )
        //     {
        //         cur = cur.child[ w.charAt( j++ ) - 'a' ];
        //         if( cur.isEnd ) break;
        //     }
        //     // make sure there exist a valid root 
        //     if( cur.isEnd ) words[ i ] = cur.word;
        // }
        // return String.join( " ", words );

        // Runtime: 20 ms, faster than 48.67% of Java online submissions for Replace Words.
        // Memory Usage: 53.8 MB, less than 75.00% of Java online submissions for Replace Words.
        StringBuilder ans = new StringBuilder();
        for( String word: sentence.split( "\\s+" ) )
        {
            if( ans.length() > 0 ) ans.append( " " ); // the delimiter

            TrieNode cur = root;
            for( char letter: word.toCharArray() )
            {
                if( cur.child[letter - 'a' ] == null || cur.isEnd ) break;
                cur = cur.child[ letter - 'a' ];
            }
            // make sure there exist a valid root
            ans.append( cur.isEnd ? cur.word : word );
        }
        return ans.toString();
    }
    
    private class TrieNode
    {
        TrieNode[] child;
        String word;
        boolean isEnd;
        
        public TrieNode()
        {
            this.child = new TrieNode[ 26 ];
            this.isEnd = false;
            this.word = "";
        }
    }
}