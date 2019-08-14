package app;

// Runtime: 1 ms, faster than 74.15% of Java online submissions for Backspace String Compare.
// Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Backspace String Compare.
class Q844_backspace_str_compare
{
    public boolean backspaceCompare(String S, String T)
    {
        return edit( S ).equals( edit( T ) );
    }
    
    private String edit( String type )
    {
        StringBuilder str = new StringBuilder();
        for( int i = 0; i < type.length(); i++ )
        {
            if( type.charAt( i ) == '#' )
            {
                if( str.length() > 0 ) str.deleteCharAt( str.length()-1 );
                continue;
            }
            str.append( type.charAt( i ) );
        }
        return str.toString();
    }
}