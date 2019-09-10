package app;

class Q647_palindromic_substrs_EXPANDCENTER
{
    public int countSubstrings(String s)
    {
        if( s == null || s.length() == 0 ) return 0;
        
        int cnt = 0;
        for( int i = 0; i < s.length(); i++ )
        {
            cnt += expandCenter( s, i, i );    // odd length palindrome
            cnt += expandCenter( s, i, i+1 );  // even length palindrome
        }
        return cnt;
    }
    
    private int expandCenter( String s, int l, int r )
    {
        int cnt = 0;
        // expanding from the center, so l-- / r++!!
        while( l >= 0 && r < s.length() && s.charAt( l-- ) == s.charAt( r++ ) ) cnt++;
        return cnt;
    }
}