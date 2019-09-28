package app;

class Q186_reverse_words_in_a_str_2_TWOPOINTER
{
    public void reverseWords(char[] s)
    {
        // 1. reverse the whole string
        reverse( s, 0, s.length-1 );
        
        // 2. reverse each word
        for( int i = 0, anchor = 0; i <= s.length; i++ )
            if( i == s.length || s[ i ] == ' ' )
            {
                reverse( s, anchor, i-1 );
                anchor = i + 1;
            }
    }
    
    private void reverse( char[] arr, int i, int j )
    {
        while( i <= j )
        {
            char t = arr[ i ];
            arr[ i ] = arr[ j ];
            arr[ j ] = t;
            
            i++; j--;
        }
    }
}