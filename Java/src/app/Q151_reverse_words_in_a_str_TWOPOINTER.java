package app;

class Q151_reverse_words_in_a_str_TWOPOINTER
{
    public String reverseWords(String s)
    {
        char[] arr = s.toCharArray();

        // 1. reverse the whole string
        reverse( arr, 0, arr.length-1 );
        
        // 2. reverse each word
        for( int i = 0, anchor = 0; i <= arr.length; i++ )
            if( i == arr.length || arr[ i ] == ' ' )
            {
                // skip the repeated spaces
                if( anchor < arr.length && arr[ anchor ] != ' ' )
                    reverse( arr, anchor, i-1 );
                anchor = i + 1;
            }
        
        // 3. get rid of the repeated spaces
        int i = 0, j = 0, n = arr.length;
        while( j < n )
        {
            // skip leading spaces
            while( j < n && arr[ j ] == ' ' ) j++;
            // shift the word
            while( j < n && arr[ j ] != ' ' ) arr[ i++ ] = arr[ j++ ];
            // skip trailing spaces
            while( j < n && arr[ j ] == ' ' ) j++;
            // keep 1 space
            if( j < n ) arr[ i++ ] = ' ';
        }
        // get the result
        return new String( arr ).substring( 0, i );
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
    
    // public String reverseWords(String s)
    // {
    //     String[] words = s.trim().split( "\\s+" );
    //     String ans = "";
    //     for( int i = words.length-1; i >= 0; i-- )
    //     {
    //         ans = (i > 0) ? ans + words[ i ] + " " : ans + words[ i ];
    //     }
    //     return ans;
    // }
}