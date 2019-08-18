// ref. https://leetcode.com/problems/word-ladder/discuss/40728/Simple-Java-BFS-solution-with-explanation

package app;

import java.util.*;

// Runtime: 50 ms, faster than 71.14% of Java online submissions for Word Ladder.
// Memory Usage: 40.1 MB, less than 78.83% of Java online submissions for Word Ladder.
class Q127_word_ladder
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Set<String> set = new HashSet<String>();
        for( String w: wordList ) set.add( w );
        if( set.contains( beginWord ) ) set.remove( beginWord );
        
        Queue<String> q = new LinkedList<String>();
        q.offer( beginWord );
        int len = 1;
        while( !q.isEmpty() )
        {
            int size = q.size();
            // BFS!! complete all the words for current level
            for( int k = 0; k < size; k++ )
            {
                String pop = q.remove();
                if( pop.equals( endWord ) ) return len;
                char[] cur = pop.toCharArray();
                // consider as the same level!!
                for( int i = 0; i < cur.length; i++ )
                    for( char j = 'a'; j <= 'z'; j++ )
                    {
                        if( cur[ i ] == j ) continue;

                        char tmp = cur[ i ];
                        cur[ i ] = j;
                        String candi = new String( cur );
                        if( set.contains( candi ) )
                        {
                            q.offer( candi );
                            // visited
                            set.remove( candi );
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