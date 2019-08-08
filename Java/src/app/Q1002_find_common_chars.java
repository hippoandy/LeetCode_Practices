// ref. https://leetcode.com/problems/find-common-characters/discuss/247558/Java-12-liner-count-and-look-for-minimum.

package app;

import java.util.*;

class Q1002_find_common_chars
{
    public List<String> commonChars(String[] A)
    {
        List<String> ans = new ArrayList<>();
        
        int[] count = new int[ 26 ]; 
        Arrays.fill(count, Integer.MAX_VALUE);

        for( String str : A )
        {
            int[] cnt = new int[ 26 ];
            // count each char's frequency in string str
            str.chars().forEach( c -> cnt[ c - 'a' ]++  );
            // update minimum frequency
            for( int i = 0; i < 26; i++ )
                // to record common char, if a char is not common, the min freq will be 0
                count[ i ] = Math.min( cnt[ i ], count[ i ] );
        }
        for( char c = 'a'; c <= 'z'; c++ )
        {
            // for potential dup char
            while( count[ c - 'a' ]-- > 0 )
                ans.add( Character.toString( c ) );
        }
        return ans;
    }
}