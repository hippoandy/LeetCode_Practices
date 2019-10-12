package app;

import java.util.*;

// brute-force with memo
// Runtime: 7 ms, faster than 53.09% of Java online submissions for Word Break II.
// Memory Usage: 39.5 MB, less than 31.15% of Java online submissions for Word Break II.
class Q140_word_break_2
{
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        // key: starting idx
        // value: list of sentences that could be formed
        //        from this starting idx onwards
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        
        Set<String> words = new HashSet<String>( wordDict );
        return backtracking( map, s, words, 0 );
    }
    
    private List<String> backtracking( Map<Integer, List<String>> map, String s, Set<String> words, int start )
    {
        // if a result already exists, return it
        if( map.containsKey( start ) ) return map.get( start );

        List<String> res = new ArrayList<String>();
        if( start == s.length() )
        {
            // base case
            res.add( "" );
        }
        for( int i = start + 1; i <= s.length(); i++ )
            if( words.contains( s.substring( start, i ) ) )
            {
                // recursive call
                List<String> list = backtracking( map, s, words, i );
                for( String w: list )
                    res.add( s.substring( start, i ) + (w.equals( "" ) ? "" : " ") + w );
            }
        // record the temporary partitioning result
        map.put( start, res );
        return res;
    }
}