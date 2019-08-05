// ref. [SOLUTION] https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
// ref. https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99111/Evolve-from-brute-force-to-dp

class Q516_longest_palindromic_subsequence
{
    public int longestPalindromeSubseq(String s)
    {
        if( s == null ) return 0;
        if( s.length() == 0 ) return 0;

        int[][] dp = new int[ s.length() ][ s.length() ];
        for( int i = s.length()-1; i >= 0; i-- )
        {
            dp[ i ][ i ] = 1;
            for( int j = i+1; j < s.length(); j++ )
            {
                if( s.charAt( i ) == s.charAt( j ) )
                    dp[ i ][ j ] = 2 + dp[ i+1 ][ j-1 ];
                else
                    dp[ i ][ j ] = Math.max(
                        dp[ i+1 ][ j ], dp[ i ][ j-1 ]
                    );
            }
        }
        return dp[ 0 ][ s.length()-1 ];
    }
    
    // // brute-force in C++
    // class Solution {
    //     public:
    //         int longestPalindromeSubseq(string s)
    //         {
    //             return dp(0,s.size()-1,s); 
    //         }
    //         int dp(int l, int r, string &s) {
    //             if(l==r) return 1;
    //             if(l>r) return 0;  //happens after "aa" 
    //             if( s[ l ] == s[ r ] )
    //                 return 2 + dp( l+1,r-1, s );
    //             else
    //                 return max(
    //                     dp( l+1,r, s ),
    //                     dp( l,r-1, s )
    //                 );
    //         }
    //     };
    // }
}