package app;

class Q925_long_pressed_name
{
    public boolean isLongPressedName(String name, String typed)
    {
        int ptr = 0;
        for( char c: name.toCharArray() )
        {
            if( ptr == typed.length() ) return false;
            
            // if mismatch
            if( typed.charAt( ptr ) != c )
            {
                // if it's the first char of the block
                if( ptr == 0 || typed.charAt( ptr-1 ) != typed.charAt( ptr ) ) return false;
                
                // skip the same char
                char cur = typed.charAt( ptr );
                while( ptr < typed.length() && typed.charAt( ptr ) == cur ) ptr++;
                
                // prevent out of bound!
                if( ptr == typed.length() || typed.charAt( ptr ) != c ) return false;
            }
            ptr++;
        }
        return true;
    }
}