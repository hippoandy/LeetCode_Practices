package app;

import java.util.*;

class Q387_first_unique_char_in_a_str
{
    public int firstUniqChar(String s)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for( int i = 0; i < s.length(); i++ )
        {
            char c = s.charAt( i );
            map.put( c, map.getOrDefault( c, 0 ) + 1 );
        }
        
        for( int i = 0; i < s.length(); i++ )
            if( map.get( s.charAt( i ) ) == 1 ) return i;
        return -1;
    }
}