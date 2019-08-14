package app;

class Q796_rotate_str
{
    public boolean rotateString(String A, String B)
    {
        if( A == null || B == null ) return false;
        if( A.length() != B.length() ) return false;
        if( A.equals( B ) ) return true;

        for( int s = 1; s < A.length(); s++ )
        {
            StringBuilder shifted = new StringBuilder();
            for( int i = s; i < A.length(); i++ )
                shifted.append( A.charAt( i ) );
            for( int i = 0; i < s; i++ )
                shifted.append( A.charAt( i ) );
            if( kmp( shifted.toString(), B ) != -1 ) return true;
        }
        return false;
    }
    
    private int kmp( String txt, String pat )
    {
        int m = txt.length(), n = pat.length();
        int[] presuffix = new int[ n ];
        
        // build the prefix-suffix array
        int j = 0, i = 1;
        while( i < n )
        {
            if( pat.charAt( i ) == pat.charAt( j ) )
                presuffix[ i++ ] = ++j;
            else
            {
                if( j != 0 )
                    j = presuffix[ j-1 ];
                else
                    presuffix[ i++ ] = j;
            }
        }
        i = 0; j = 0;
        while( i < m && j < n )
        {
            if( txt.charAt( i ) == pat.charAt( j ) )
            {
                i++; j++;
            }
            
            if( j == n ) return i-j;
            else if( i < m && txt.charAt( i ) != pat.charAt( j ) )
            {
                if( j > 0 ) j = presuffix[ j-1 ];
                else i++;
            }
        }
        return (j == n) ? i-j : -1;
    }
}