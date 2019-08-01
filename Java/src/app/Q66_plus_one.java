// ref. https://leetcode.com/problems/plus-one/discuss/24139/Simple-java-solution

package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
// Memory Usage: 35.1 MB, less than 98.91% of Java online submissions for Plus One.
class Q66_plus_one
{
    public int[] plusOne(int[] digits)
    {
        int carry = 0;
        for( int i = digits.length-1; i >= 0; i-- )
        {
            int sum = ( i == digits.length-1 ) ? (digits[ i ] + 1) : (digits[ i ] + carry);
            digits[ i ] = sum % 10;
            carry = sum / 10;
        }
        // for case [9], [9, 9], [9, 9, 9], ......
        if( carry == 1 )
        {
            int[] res = new int[ digits.length+1 ];
            res[ 0 ] = 1;
            return res;
        }
        return digits;
    }
}