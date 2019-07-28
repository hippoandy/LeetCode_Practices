// ref. https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812/Share-my-Java-solution-using-HashSet

package app;

import java.util.*;

// Runtime: 10 ms, faster than 39.75% of Java online submissions for Longest Substring Without Repeating Characters.
// Memory Usage: 36.7 MB, less than 99.86% of Java online submissions for Longest Substring Without Repeating Characters.
class Q3_longest_substr_without_repeating_chars_SET
{
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0,
            i = 0,      // slow pointer
            j = 0;      // fast pointer
        while( i < n && j< n )
        {
            if( !set.contains( s.charAt( j ) ) )
            {
                // try to extend the window
                set.add( s.charAt( j ) );
                j++;
                ans = Math.max( ans, j-i );
            }
            else
            {
                // shorten the window
                set.remove( s.charAt( i ) );
                i++;
            }
        }
        return ans;
    }
}