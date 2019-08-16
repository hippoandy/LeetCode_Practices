// ref. https://leetcode.com/problems/find-the-closest-palindrome/discuss/147949/Thinking-Process

package app;

// Runtime: 2 ms, faster than 98.30% of Java online submissions for Find the Closest Palindrome.
// Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Find the Closest Palindrome.
class Q564_find_the_closest_palindrome
{
    public String nearestPalindromic(String n)
    {
        long val = Long.parseLong( n );
        int len = n.length();

        /* corner cases:
            case 1. <= 10, OR equal to 100, 1000, 10000, ... simply decrease n by 1.
            case 2. 11, 101, 1001, 10001, 100001, ... simply decrease n by 2.
            case 3. 99, 999, 9999, 99999, ... simply increase n by 2.
         */
        // case 1
        if( val <= 10 ||
            (val != 0 && n.charAt( 0 ) == '1' && Long.parseLong( n.substring( 1 ) ) == 0)
          )
            return Long.toString( val - 1 );
        // case 2
        if( val == 11 ||
            (n.charAt( 0 ) == '1' && n.charAt( len-1 ) == '1' && Long.parseLong( n.substring( 1, len-1 ) ) == 0)
        )
            return Long.toString( val - 2 );
        // case 3
        if( allDigitNine( n ) ) return Long.toString( val + 2 );
        
        boolean isEven = (len % 2 == 0);
        String root = (isEven) ? n.substring( 0, len / 2 ) : n.substring( 0, len / 2 + 1 );
        int rootVal = Integer.parseInt( root );
        
        // consider number 12321, root = 123
        // equal
        long equal = counterParts( root, isEven );
        long diffE = Math.abs( val - equal );
        
        // smaller, 122 (123 - 1)
        long smaller = counterParts( Long.toString( rootVal - 1 ), isEven );
        long diffS = Math.abs( val - smaller );
        
        // bigger, 124 (123 + 1)
        long bigger = counterParts( Long.toString( rootVal + 1 ), isEven );
        long diffB = Math.abs( val - bigger );

        // find the palindrome with minimum absolute differences
        // if tie, return the smaller one
        // ">=" since default to choose the smaller value!
        long closest = (diffB >= diffS) ? smaller : bigger;
        long minDiff = (diffB >= diffS) ? diffS : diffB;
        
        // n is not a palindrome, diffE should be considered
        if( diffE != 0 )
        {
            if( diffE == minDiff )
                closest = Math.min( equal, closest );
            else
                closest = (diffE < minDiff) ? equal : closest;
        }
        return Long.toString( closest );
    }
    
    private long counterParts( String n, boolean isEven )
    {
        StringBuilder reverse = new StringBuilder( n ).reverse();

        String res = isEven
            ? n + reverse.toString()
            // if the length is odd, remove the first digit of the reverse part
            : n + (reverse.deleteCharAt( 0 )).toString();

        return Long.parseLong( res );
    }
    
    private boolean allDigitNine( String n )
    {
        for( char c: n.toCharArray() )
            if( c != '9' ) return false;
        return true;
    }
}