// ref. https://leetcode.com/problems/word-ladder/discuss/40728/Simple-Java-BFS-solution-with-explanation

package app;

import java.util.*;

// Runtime: 52 ms, faster than 66.12% of Java online submissions for Word Ladder.
// Memory Usage: 39.9 MB, less than 84.67% of Java online submissions for Word Ladder.
class Q127_word_ladder
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        // record all the unvisited words
        Set<String> remains = new HashSet<String>( wordList );
        // begin word could not be a possible choice
        if( remains.contains( beginWord ) ) remains.remove( beginWord );
        
        Queue<String> q = new LinkedList<String>();
        q.offer( beginWord );
        int len = 1;
        while( !q.isEmpty() )
        {
            int size = q.size();
            // BFS, complete all the words for current level
            // consider all the possible alterations as the same level
            for( int k = 0; k < size; k++ )
            {
                String pop = q.remove();
                if( pop.equals( endWord ) ) return len;
                char[] cur = pop.toCharArray();
                // change one char by a time
                for( int i = 0; i < cur.length; i++ )
                    for( char j = 'a'; j <= 'z'; j++ )
                    {
                        // skip the same char
                        if( cur[ i ] == j ) continue;

                        char tmp = cur[ i ];
                        cur[ i ] = j;
                        String candi = new String( cur );
                        // remains set contains that word, unvisited yet
                        if( remains.contains( candi ) )
                        {
                            q.offer( candi );
                            // remove from the remains set, as visited
                            remains.remove( candi );
                        }
                        // restore
                        cur[ i ] = tmp;
                    }
            }
            // only add the number at the end of the current level
            // (all possible transformation being considered for the same word)
            len++;
        }
        return 0;
    }
}