// ref. https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87741/Java-divide-and-conquer(recursion)-solution

package app;

// Runtime: 80 ms, faster than 16.40% of Java online submissions for Longest Substring with At Least K Repeating Characters.
// Memory Usage: 35.8 MB, less than 61.63% of Java online submissions for Longest Substring with At Least K Repeating Characters.
class Q395_longest_substr_with_at_least_k_repeating_chars
{
    public int longestSubstring(String s, int k)
    {
        return helper( s, 0, s.length(), k );
    }
    
    private int helper( String s, int start, int end, int k )
    {
        /**
         * Base Case 1 of 2:
         * 
         * If this substring is shorter than k, then no characters in it
         * can be repeated k times, therefore this substring and all
         * substrings that could be formed from it are invalid,
         * therefore return 0.
         */
        if( end - start < k ) return 0;

        int[] count = new int[ 26 ];
        // count the occurence
        for( int i = start; i < end; i++ )
            count[ s.charAt( i ) - 'a' ]++;
        for( int i = 0; i < 26; i++ )
        {
            // count[i] == 0 => i+'a' does not exist in the string, skip it.
            /**
             * If this character occurs at least once, but fewer than k times
             * in this substring, we know:
             * (1) this character cannot be part of the longest valid substring,
             * (2) the current substring is not valid.
             * 
             * Hence, we will "split" this substring on this character,
             * wherever it occurs, and check the substrings formed by that split
             */
            if( count[ i ] < k && count[ i ] > 0 )
            {
                for( int j = start; j < end; j++ )
                {
                    if( s.charAt( j ) == (char) i + 'a' )
                    {
                        int left  = helper( s, start,   j, k );
                        int right = helper( s,   j+1, end, k );
                        return Math.max( left, right );
                    }
                }
            }
        }
        /**
         * Base Case 2 of 2:
         * 
         * If every character in this substring occurs at least k times,
         * then this is a valid substring, so return this substring's length.
         */
        return end - start;
    }
    
    // // only for finding substring that built up using same char......
    // public int longestSubstring(String s, int k)
    // {
    //     if( s == null || s.length() == 0 ) return 0;
    //     int[] dp = new int[ s.length() ];
    //     dp[ 0 ] = 1;
    //     int max = 0;
    //     for( int i = 1; i < s.length(); i++ )
    //     {
    //         if( s.charAt( i ) == s.charAt( i-1 ) )
    //             dp[ i ] = dp[ i-1 ] + 1;
    //         if( dp[ i ] >= k )
    //             max = Math.max( max, dp[ i ] );
    //     }
    //     return max;
    // }
}