// ref. https://leetcode.com/problems/regular-expression-matching/discuss/191830/Java-DP-solution-beats-100-with-explanation

package app;

class Q10_regular_expression_matching
{
    public boolean isMatch(String s, String p)
    {
        if( p == null || p.length() == 0 )
            return (s == null || s.length() == 0);

        int m = s.length();
        int n = p.length();

        boolean [][] dp = new boolean[ m+1 ][ n+1 ];

        /* Transition funtions:
           1) If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
           2) If p.charAt(j) == '.' :          dp[i][j] = dp[i-1][j-1];
           3) If p.charAt(j) == '*': 
               here are two sub conditions:
               a) if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]
                  //in this case, a* only counts as empty

               b) if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                      dp[i][j] = dp[i-1][j] // in this case, a* counts as multiple a 
                   or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
                   or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
        */

        /* s='aab', p='c*a*b'

                  c * a * b
                0 1 2 3 4 5
              0 T F T F T F
            a 1 F F F T T F
            a 2 F F F F T F
            b 3 F F F F F T

         */

        // dp init
        dp[ 0 ][ 0 ] = true;        
        for( int j = 2; j <= n; j++ )
            dp[ 0 ][ j ] = p.charAt( j-1 ) == '*' && dp[ 0 ][ j-2 ]; 

        for( int j = 1; j <= n; j++ )
            for( int i = 1; i <= m; i++ )
            {
                // case 1 & 2
                // indexes using a -1 offset that is because dp array is one index bigger
                if( p.charAt( j-1 ) == s.charAt( i-1 ) || p.charAt( j-1 ) == '.' ) 
					dp[ i ][ j ] = dp[ i-1 ][ j-1 ];
                else if( p.charAt(j-1) == '*' )
                    dp[ i ][ j ] = dp[i][j-2] ||
                        ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]); 
            }

        return dp[ m ][ n ];
    }
}