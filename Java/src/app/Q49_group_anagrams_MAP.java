package app;

import java.util.*;

// Time Complexity: O(NKlogK)
class Q49_group_anagrams_MAP
{
    public List<List<String>> groupAnagrams( String[] strs )
    {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for( String s: strs )
        {
            char[] letters = s.toCharArray();
            Arrays.sort( letters );
            String key = new String( letters );
            if( !map.containsKey( key ) ) map.put( key, new ArrayList<String>() );
            map.get( key ).add( s );
        }
        return new ArrayList<List<String>>( map.values() );
    }
}