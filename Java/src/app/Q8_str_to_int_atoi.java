// ref. https://leetcode.com/problems/string-to-integer-atoi/discuss/4643/Java-Solution-with-4-steps-explanations

package app;

class Q8_str_to_int_atoi
{
    public int myAtoi(String str)
    {
        if( str.length() == 0 ) return 0;
        
        int idx = 0, num = 0, sign = 1;
        
        // 1. leading spaces
        while( idx < str.length() && str.charAt( idx ) == ' ' ) idx++;
        if( idx == str.length() ) return 0;
        
        // 2. get the sign
        if( str.charAt( idx ) == '+' || str.charAt( idx ) == '-' )
        {
            sign = (str.charAt( idx ) == '+') ? 1 : -1;
            idx++;
        }
        
        // 3. convert number part to num
        while( idx < str.length() )
        {
            int digit = str.charAt( idx ) - '0';
            // not a number, return!
            if( digit < 0 || digit > 9 ) break;
            
            // check for overflow
            if( Integer.MAX_VALUE / 10 < num ||
                Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < digit )
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            num = num * 10 + digit;
            idx++;
        }
        return num * sign;
    }
}