// ref. https://stackoverflow.com/questions/17124992/incrementing-char-type-in-java

package app;

class Q709_to_lower_case
{
    public String toLowerCase(String str)
    {
        char[] arr = str.toCharArray();
        for( int i = 0; i < arr.length; i++ )
            if( isCapital( arr[ i ] ) )
                arr[ i ] += 32;
        return new String( arr );
    }
    
    private boolean isCapital( char c )
    {
        if( c < 'A' || c > 'Z' ) return false;
        return true;
    }
}