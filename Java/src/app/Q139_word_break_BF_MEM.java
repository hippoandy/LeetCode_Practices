package app;

import java.util.*;

// Runtime: 4 ms, faster than 77.80% of Java online submissions for Word Break.
// Memory Usage: 36.7 MB, less than 86.33% of Java online submissions for Word Break.
// Time complexity : O(n^2). Size of recursion tree can go up to n^2
// Space complexity: O(n)
class Q139_word_break_BF_MEM
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        return backtracking( s, new HashSet<String>( wordDict ), 0, new Boolean[ s.length() ] );
    }
    
    public boolean backtracking( String s, Set<String> dict, int start, Boolean[] memo )
    {
        if( start == s.length() ) return true;
        
        // use wrapper class!!
        if( memo[ start ] != null ) return memo[ start ];

        for( int end = start + 1; end <= s.length(); end++ )
            // keep cutting the string
            if( dict.contains( s.substring( start, end ) ) && backtracking( s, dict, end, memo ) )
            {
                memo[ start ] = true;
                return true;
            }
        memo[ start ] = false;
        return false;
    }
}