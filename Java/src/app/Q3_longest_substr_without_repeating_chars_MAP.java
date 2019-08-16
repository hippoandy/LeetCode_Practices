package app;

import java.util.*;

// Runtime: 7 ms, faster than 82.37% of Java online submissions for Longest Substring Without Repeating Characters.
// Memory Usage: 35.9 MB, less than 99.96% of Java online submissions for Longest Substring Without Repeating Characters.
class Q3_longest_substr_without_repeating_chars_MAP
{    
    public int lengthOfLongestSubstring(String s)
    {
        if( s == null ) return 0;
        if( s.length() == 0 ) return 0;
        
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for( int j = 0, i = 0; j < n; j++ )
        {
            if( map.containsKey( s.charAt( j ) ) )
                i = Math.max( map.get( s.charAt( j ) ), i );
            ans = Math.max( ans, j-i+1 );  // +1 since 0-index
            map.put( s.charAt( j ), j+1 );
        }
        return ans;
    }

    /* second version
    public int lengthOfLongestSubstring(String s)
    {
        if( s == null ) return 0;
        if( s.length() == 0 ) return 0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for( int i = 0, j = 0; j < s.length(); j++ )
        {
            char c = s.charAt( j );
            if( map.containsKey( c ) ) i = (map.get( c ) > i) ? map.get( c ) : i;
            max = (j - i + 1 > max) ? j -i + 1 : max;
            map.put( c, j+1 );
        }
        return max;
    }
    */
    
    // // hashset
    // public int lengthOfLongestSubstring(String s)
    // {
    //     int n = s.length();
    //     Set<Character> set = new HashSet<Character>();
    //     int ans = 0,
    //         i = 0,      // slow pointer
    //         j = 0;      // fast pointer
    //     while( i < n && j< n )
    //     {
    //         if( !set.contains( s.charAt( j ) ) )
    //         {
    //             // try to extend the window
    //             set.add( s.charAt( j ) );
    //             j++;
    //             ans = Math.max( ans, j-i );
    //         }
    //         else
    //         {
    //             // shorten the window
    //             set.remove( s.charAt( i ) );
    //             i++;
    //         }
    //     }
    //     return ans;
    // }
}