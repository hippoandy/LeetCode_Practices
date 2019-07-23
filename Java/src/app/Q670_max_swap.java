package app;

class Q670_max_swap
{
    public int maximumSwap(int num)
    {
        char[] nstr = Integer.toString( num ).toCharArray();
        // the index i of the last occurrence of digit (if it exists)
        int[] last = new int[ 10 ]; // record for 0 - 9;
        for( int i = 0; i < nstr.length; i++ )
            last[ nstr[ i ] - '0' ] = i;
        
        // scan from left to right
        for( int i = 0; i < nstr.length; i++ )
            for( int d = 9; d > nstr[ i ] - '0'; d-- )
            {
                // if there is any digit exists larger than the current digit
                if( last[ d ] > i )
                {
                    char tmp = nstr[ i ];
                    nstr[ i ] = nstr[ last[ d ] ];
                    nstr[ last[ d ] ] = tmp;
                    // return here since we could only swap once
                    return Integer.valueOf( new String( nstr ) );
                }
            }
        return num;
    }
}