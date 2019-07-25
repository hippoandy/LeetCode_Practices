// ref. https://leetcode.com/problems/is-subsequence/discuss/87254/Straight-forward-Java-simple-solution

package app;

class Q392_is_subsequence
{
    public boolean isSubsequence(String s, String t)
    {
        if( s.length() == 0 ) return true;
        if( t.length() == 0 ) return false;
        
        int idx_s = 0, idx_t = 0;
        while( idx_t < t.length() )
        {
            if( t.charAt( idx_t ) == s.charAt( idx_s ) )
            {
                idx_s++;
                if( idx_s == s.length() ) return true;
            }
            idx_t++;
        }
        return false;
    }
}