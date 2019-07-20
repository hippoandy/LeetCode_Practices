package app;

class Q443_str_compression
{
    public int compress(char[] chars)
    {
        int anchor = 0,  write = 0;
        for( int read = 0; read < chars.length; read++ )
        {
            // check the next char
            if( read + 1 == chars.length || chars[ read + 1 ] != chars[ read ] )
            {
                chars[ write++ ] = chars[ anchor ];
                // indicate that there are duplicate char
                if( read > anchor )
                {
                    // the count of the same char
                    for( char c: Integer.toString( read - anchor + 1 ).toCharArray() )
                        chars[ write++ ] = c;
                }
                anchor = read + 1;
            }
        }
        // return the last position be written
        return write;
    }
}