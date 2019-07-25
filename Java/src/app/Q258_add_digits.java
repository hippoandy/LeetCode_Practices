// ref. https://leetcode.com/problems/add-digits/discuss/68580/Accepted-C%2B%2B-O(1)-time-O(1)-space-1-Line-Solution-with-Detail-Explanations
// ref. [WIKIPEDIA] https://www.wikiwand.com/en/Digital_root

package app;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Digits.
// Memory Usage: 33.4 MB, less than 5.09% of Java online submissions for Add Digits.
class Q258_add_digits
{
    public int addDigits(int num)
    {
        if( num >= 10 )
        {
            String str = Integer.toString( num );
            int total = 0;
            for( int i = 0; i < str.length(); i++ )
                total += str.charAt( i ) - '0';
            return addDigits( total );
        }
        else
            return num;
    }
}