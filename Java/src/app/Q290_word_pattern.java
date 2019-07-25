// ref. https://leetcode.com/problems/word-pattern/discuss/73533/Java-Solution-with-a-hashmap-and-a-hashset

package app;

import java.util.*;

class Q290_word_pattern
{
    public boolean wordPattern(String pattern, String str)
    {
        String[] words = str.split( " " );
        if( words.length != pattern.length() ) return false;

        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        
        for( int i = 0; i < words.length; i++ )
        {
            char c = pattern.charAt( i );
            if( !map.containsKey( c ) )
            {
                if( set.contains( words[ i ] ) ) return false;
                map.put( c, words[ i ] );
                set.add( words[ i ] );
            }
            else
                if( !words[ i ].equals( map.get( c ) ) ) return false;
        }
        return true;
    }
}