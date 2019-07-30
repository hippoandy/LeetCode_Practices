// ref. https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation

package app;

import java.util.*;

class Q91_decode_ways
{
    Map<String, Character> table;

    public int numDecodings(String s)
    {
        buildTable();
        
        int[] dp = new int[ s.length() ];
        dp[ 0 ] = s.charAt( 0 ) == '0' ? 0 : 1;
        
        for( int i = 1; i < s.length(); i++ )
        {
            // size 1
            if( table.containsKey( s.substring( i, i+1 ) ) )
                dp[ i ] += dp[ i-1 ];
            // size 2
            if( table.containsKey( s.substring( i-1, i+1 ) ) )
                dp[ i ] += (i >= 2) ? dp[ i-2 ] : 1;
        }
        return dp[ s.length()-1 ];
    }
    
    private void buildTable()
    {
        table = new HashMap<String, Character>();
        
        table.put(  "1", 'A' ); table.put( "14", 'N' );
        table.put(  "2", 'B' ); table.put( "15", 'O' );
        table.put(  "3", 'C' ); table.put( "16", 'P' );
        table.put(  "4", 'D' ); table.put( "17", 'Q' );
        table.put(  "5", 'E' ); table.put( "18", 'R' );
        table.put(  "6", 'F' ); table.put( "19", 'S' );
        table.put(  "7", 'G' ); table.put( "20", 'T' );
        table.put(  "8", 'H' ); table.put( "21", 'U' );
        table.put(  "9", 'I' ); table.put( "22", 'V' );
        table.put( "10", 'J' ); table.put( "23", 'W' );
        table.put( "11", 'K' ); table.put( "24", 'X' );
        table.put( "12", 'L' ); table.put( "25", 'Y' );
        table.put( "13", 'M' ); table.put( "26", 'Z' );
    }
}