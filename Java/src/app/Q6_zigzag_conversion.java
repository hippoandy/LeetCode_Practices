// ref. https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution

package app;

class Q6_zigzag_conversion
{
    public String convert(String s, int numRows)
    {
        if( s == null || s.length() == 0 ) return s;
        if( numRows <= 0 ) throw null;
        
        char[] c = s.toCharArray();
        int len = c.length;

        // init
        StringBuffer[] sb = new StringBuffer[ numRows ];
        for( int i = 0; i < sb.length; i++ ) sb[ i ] = new StringBuffer();

        int i = 0;
        while( i < len )
        {
            // vertically down
            for( int idx = 0; idx < numRows && i < len; idx++ )
                sb[ idx ].append( c[ i++ ] );
            // obliquely up
            // "numRows-2" since after the first for loop, i will be larger than the index
            for( int idx = numRows-2; idx >= 1 && i < len; idx-- )
                sb[ idx ].append( c[ i++ ] );
        }
        // append the solution
        for( int idx = 1; idx < sb.length; idx++ )
            sb[ 0 ].append( sb[ idx ] );
        return sb[ 0 ].toString();
    }
}