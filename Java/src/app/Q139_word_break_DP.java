package app;

import java.util.*;

class Q139_word_break_DP
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        Set<String> dict = new HashSet<String>( wordDict );
        boolean[] dp = new boolean[ s.length() + 1 ];
        // dp init
        dp[ 0 ] = true;
        for( int i = 1; i <= s.length(); i++ )
            for( int j = 0; j < i; j++ )
                if( dp[ j ] && dict.contains( s.substring( j, i ) ) )
                {
                    dp[ i ] = true;
                    break;  // could break or just keep running
                }
        return dp[ s.length() ];
    }
}