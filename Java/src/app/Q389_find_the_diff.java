package app;

// Runtime: 2 ms, faster than 45.68% of Java online submissions for Find the Difference.
// Memory Usage: 37.8 MB, less than 6.41% of Java online submissions for Find the Difference.
class Q389_find_the_diff
{
    public char findTheDifference(String s, String t)
    {
        int[] count = new int[ 26 ];
        for( int i = 0; i < s.length(); i++ )
            count[ s.charAt( i ) - 'a' ]++;
        for( int i = 0; i < t.length(); i++ )
            if( --count[ t.charAt( i ) - 'a' ] < 0 ) return t.charAt( i );
        throw null;
    }
}