package app;

// Runtime: 96 ms, faster than 9.11% of Java online submissions for Palindromic Substrings.
// Memory Usage: 36.3 MB, less than 45.57% of Java online submissions for Palindromic Substrings.
class Q647_palindromic_substrs_BF
{
    public int countSubstrings(String s)
    {
        if( s == null || s.length() == 0 ) return 0;
        int count = 0;
        for( int i = 0; i < s.length(); i++ )
            for( int j = i+1; j <= s.length(); j++ )
            {
                String cur = s.substring( i, j );
                if( isPalindromic( cur ) ) count++;
            }
        return count;
    }
    
    private boolean isPalindromic( String s )
    {
        int l = 0, r = s.length() - 1;
        while( l < r )
            if( s.charAt( l++ ) != s.charAt( r-- ) ) return false;
        return true;
    }
}