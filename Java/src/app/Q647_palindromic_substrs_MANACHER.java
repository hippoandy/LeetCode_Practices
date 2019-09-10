package app;

class Q647_palindromic_substrs_MANACHER
{
    public int countSubstrings(String s)
    {
        if( s == null || s.length() == 0 ) return 0;
        char[] A = seperation( s );

        // manacher's algorithm
        int[] len = new int[ A.length ];
        int center = 0, r = 0;
        
        for( int i = 1; i < len.length-1; i++ )
        {
            if( i < r ) len[ i ] = Math.min( r - i, len[ 2 * center - i ] );
            
            // palindrome
            while( A[ i + len[ i ] + 1 ] == A[ i - len[ i ] - 1 ] ) len[ i ]++;
            
            // out of current palindrom bound, choose new mirror center
            if( i + len[ i ] > r )
            {
                center = i;
                r = i + len[ i ];
            }
        }
        
        int ans = 0;
        for( int e: len ) ans += (e + 1) / 2;
        return ans;
    }

    // to easily deal with even length substring
    // hard to find center for even length, so make it odd length
    private char[] seperation( String s )
    {
        char[] A = new char[ s.length() * 2 + 3 ];
        A[ 0 ] = '@';
        A[ 1 ] = '#';
        int i = 2;
        for( char c: s.toCharArray() )
        {
            A[ i++ ] = c;
            A[ i++ ] = '#';
        }
        A[ A.length - 1 ] = '$';
        return A;
    }
}