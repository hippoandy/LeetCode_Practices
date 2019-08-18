// ref. https://leetcode.com/problems/word-ladder-ii/discuss/40536/Clear-Java-solution-with-a-single-BFS

package app;

import java.util.*;

class Q126_word_ladder_2
{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        Set<String> remains = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        for( String w: wordList ) remains.add( w );
        
        List<List<String>> ans = new ArrayList<List<String>>();

        int level = 1, minHeight = Integer.MAX_VALUE;
        
        Queue<Info> q = new LinkedList<Info>();
        q.offer( new Info( beginWord, null, level ) );

        while( !q.isEmpty() )
        {
            Info cur = q.remove();
            // the current path is too long, discard it
            if( cur.level > minHeight ) break;

            // the minHeight will only be changed when the path reached the end word
            if( cur.word.equals( endWord ) && cur.level <= minHeight )
            {
                minHeight = cur.level;
                addPath( ans, cur );
                continue;
            }
            // when the previous level is finished, delete all the nodes of visited form the remains
            //
            // In this task we want to find all shortest paths.
            // This means that we might need to reuse some nodes and
            // make sure that we don't prune paths that are still valid.
            // We need to make sure that we remove nodes when there is
            // no shorter path that leads to them.
            // That's why we have "if ( cur.level > level) ""
            if( cur.level > level )
            {
                remains.removeAll( visited );
                level = cur.level;
            }

            char[] chars = cur.word.toCharArray();
            for( int j = 0; j < chars.length; j++ )
                for( char k = 'a'; k <= 'z'; k++ )
                {
                    if( chars[ j ] == k) continue; // do nothing for the same char

                    char tmp = chars[ j ];
                    chars[ j ] = k;
                    String candi = new String( chars );
                    if( remains.contains( candi ) )
                    {
                        q.offer( new Info( candi, cur, cur.level+1 ) );
                        // do not remove element from remains here!! (see above)
                        visited.add( candi );
                    }
                    // remember to restore
                    chars[ j ] = tmp;
                }
        }
        return ans;
    }
    
    private void addPath( List<List<String>> ans, Info cur )
    {
		List<String> path = new ArrayList<>();
		while( cur != null )
        {
			path.add( 0, cur.word ); // since we are traversing back from node to root
			cur = cur.parent;
		}
		ans.add( path );
	}
    
    private class Info
    {
        int level;
        String word;
        Info parent;    // store the previous word before changing char
        
        public Info( String word, Info parent, int level )
        {
            this.level = level;
            this.word = word;
            this.parent = parent;
        }
    }
}