package app;

import java.util.*;

// Runtime: 17 ms, faster than 16.59% of Java online submissions for Rotated Digits.
// Memory Usage: 35.3 MB, less than 8.33% of Java online submissions for Rotated Digits.
class Q788_rotated_digits_BF
{
    public int rotatedDigits(int N)
    {
        if( N < 1 ) throw new IllegalArgumentException( "N in range [1, 10000]" );
        
        Set<Character> diff = new HashSet<Character>( Arrays.asList( '2', '5', '6', '9' ) );
        Set<Character> flip = new HashSet<Character>( Arrays.asList( '0', '1', '2', '5', '6', '8', '9' ) );
        int count = 0;
        for( int i = 1; i <= N; i++ )
        {
            String num = Integer.toString( i );
            int pass = 0;
            boolean valid = false;
            for( int j = 0; j < num.length(); j++ )
            {
                char c = num.charAt( j );
                if( !flip.contains( c ) ) break;
                pass++;
                if( diff.contains( c ) ) valid = true;
            }
            if( pass == num.length() && valid ) count++;
        }
        return count;
    }
}