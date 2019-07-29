// ref. https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution

package app;

import java.util.*;

class Q131_palindrome_partitioning
{
    // refer to Q5
    public List<List<String>> partition( String s )
    {
        List<List<String>> ans = new ArrayList<List<String>>();
        if( s == null || s.length() == 0 ) return ans;
        int n = s.length();
        
        boolean[][] dp = new boolean[ n ][ n ];
        // dp init
        for( int i = 0; i < n; i++ )
            dp[ i ][ i ] = true;

        /*** find palindrome in the string ***/
        // Algorithm 1: top-down
        // for( int i = 0; i < n; i++ )
        //     for( int j = 0; j <= i; j++ )
        //     {
        //         if( s.charAt( i ) == s.charAt( j ) && (i-j <= 2) || dp[ j+1 ][ i-1 ] )
        //             dp[ i ][ j ] = true;
        //     }
        // Algorithm 2: bottom-up
        for( int i = n - 1; i >= 0; i-- )
            for( int dist = 1; dist < n - i; dist++ )
            {
                int j = dist + i;
                if (dist == 1)
                    dp[ i ][ j ] = (s.charAt(i) == s.charAt(j));
                else
                    dp[ i ][ j ] = (s.charAt(i) == s.charAt(j)) && dp[ i+1 ][ j-1] ;
            }
        
        // find the substring
        backtracking( ans, new ArrayList<String>(), dp, s, 0 );
        return ans;
    }
    
    private void backtracking( List<List<String>> ans, List<String> tmp, boolean[][] dp, String s, int idx )
    {
        if( idx == s.length() )
            ans.add( new ArrayList<String>( tmp ) );
        else
        {
            for( int i = idx; i < s.length(); i++ )
                if( dp[ idx ][ i ] )
                {
                    // check the first row of the dp array
                    tmp.add( s.substring( idx, i+1 ) );
                    backtracking( ans, tmp, dp, s, i+1 );
                    // restore
                    tmp.remove( tmp.size() - 1 );
                }
        }
    }
}