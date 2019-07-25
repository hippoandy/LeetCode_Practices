// ref. https://leetcode.com/problems/longest-string-chain/discuss/294890/JavaPython-Concise-DP

package app;

import java.util.*;

class Q1048_longest_str_chain
{
    public int longestStrChain(String[] words)
    {
        if( words == null )     return 0;
        if( words.length == 0 ) return 0;

        Map<String, Integer> dp = new HashMap<String, Integer>();
        // sort the array by the len of word
        Arrays.sort( words, (a, b) -> a.length() - b.length() );
        for( String w: words )
        {
            int max = 0;
            for( int i = 0; i < w.length(); i++ )
            {
                // delete each char in each loop, for example: bdca => dca -> bca -> bda -> bdc
                String pre = w.substring( 0, i ) + w.substring( i+1 );
                max = Math.max( max, dp.getOrDefault( pre, 0 ) + 1 );
            }
            dp.put( w, max );
        }
        // check the result
        int max = 0;
        for( int v: dp.values() )
            max = Math.max( max, v );
        return max;
    }
}