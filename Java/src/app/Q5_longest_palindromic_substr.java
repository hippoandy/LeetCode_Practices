// ref. https://leetcode.com/problems/longest-palindromic-substring/discuss/151144/Bottom-up-DP-Logical-Thinking

package app;

class Q5_longest_palindromic_substr
{
    public String longestPalindrome(String s)
    {
        // corner cases.
        if( s.length() <= 1 ) return s;
        
        int n = s.length(), start = 0, len = 1;
        // dp[i][j] true if s(i, j) is palindrome.
        boolean[][] dp = new boolean[ n ][ n ];
        
        // Base cases.
        for (int i = 0; i < n; i++)
            dp[ i ][ i ] = true; // dist = 0.
        
        for( int i = n - 1; i >= 0; i-- )
            for( int dist = 1; dist < n - i; dist++ )
            {
                int j = dist + i;
                if(dist == 1) 
                    dp[ i ][ j ] = (s.charAt(i) == s.charAt(j));
                else
                    dp[ i ][ j ] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];

                if( dp[ i ][ j ] && j - i + 1 > len)
                {
                    len = j - i + 1;
                    start = i;
                }
            }
        return s.substring( start, start + len );
    }
}