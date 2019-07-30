// ref. https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/51106/My-clean-Java-solution

package app;

import java.util.*;

class Q166_fraction_to_recurring_decimal
{
    public String fractionToDecimal(int numerator, int denominator)
    {
        if( numerator == 0 ) return "0";
        
        StringBuilder ans = new StringBuilder();
        
        // if a, b share the same sign, "+", else, "-"
        ans.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        
        // handling overflow
        long num = Math.abs( (long) numerator );
        long den = Math.abs( (long) denominator );
        
        // integer part
        ans.append( num/den );
        long remainder = num % den;
        // divisible
        if( remainder == 0 ) return ans.toString();
        
        // fraction part
        ans.append( "." );
        Map<Long, Integer> remainders = new HashMap<Long, Integer>();
        while( !remainders.containsKey( remainder ) )
        {
            remainders.put( remainder, ans.length() );
            ans.append( 10 * remainder / den );
            remainder = 10 * remainder % den;
        }
        
        ans.insert( remainders.get( remainder ), "(" );
        ans.append( ")" );
        // prevent for non-repeating fractional part
        return ans.toString().replace( "(0)", "" );
    }
}