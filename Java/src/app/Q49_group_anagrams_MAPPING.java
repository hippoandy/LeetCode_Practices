package app;

import java.util.*;

// Time Complexity: O(NK), where N is the length of strs, and K is the maximum length of a string in strs.
class Q49_group_anagrams_MAPPING
{
    public List<List<String>> groupAnagrams( String[] strs )
    {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for( String s: strs )
        {
            // count char occurences
            int[] count = new int[ 26 ];
            for( int i = 0; i < s.length(); i++ )
                count[ s.charAt( i ) - 'a' ]++;
            String mapping = "";
            for( int i = 0; i < count.length; i++ )
                mapping += Integer.toString( count[ i ] ) + "#";
            map.computeIfAbsent( mapping, x -> new ArrayList<String>() ).add( s );
        }
        return new ArrayList<List<String>>( map.values() );
    }
}