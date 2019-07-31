package app;

class Q880_decoded_str_at_idx
{
    public String decodeAtIndex(String S, int K)
    {
        if( S == null ) return "";
        if( S.length() == 0 | K <= 0 ) return "";
        long size = 0;
        // keeping track of the size of the decoded string.
        // Whenever the decoded string would equal some "word" repeated d times,
        // we can reduce K to K % (word.length).
        for( int i = 0; i < S.length(); i++ )
        {
            char c = S.charAt( i );
            if( Character.isDigit( c ) )
                size *= (c - '0');
            else
                size++;
        }
        
        for( int i = S.length()-1; i >= 0; i-- )
        {
            char c = S.charAt( i );
            K %= size;
            if( K == 0 && Character.isLetter( c ) ) return Character.toString( c );
            
            if( Character.isDigit( c ) )
                size /= (c - '0');
            else
                size -= 1;
        }

        throw null;
    }

    // brute-force
    // Memory Limit Exceeded!!
    // public String decodeAtIndex(String S, int K)
    // {
    //     if( S == null ) return "";
    //     if( S.length() == 0 | K <= 0 ) return "";
    //     String res = "";
    //     for( int i = 0; i < S.length(); i++ )
    //     {
    //         char c = S.charAt( i );
    //         if( Character.isDigit( c ) )
    //         {
    //             String dup = res;
    //             for( int j = Character.getNumericValue( c ) - 1; j > 0; j-- )
    //                 res += dup;
    //         }
    //         else
    //             res += Character.toString( c );
    //     }
    //     return res.substring( K-1, K );
    // }
}