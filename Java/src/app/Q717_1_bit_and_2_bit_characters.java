// ref. https://leetcode.com/problems/1-bit-and-2-bit-characters/discuss/291482/c%2B%2B-greedy

package app;

// bad question......

class Q717_1_bit_and_2_bit_characters
{
    // only '10' or '11' is valid!!
    public boolean isOneBitCharacter(int[] bits)
    {
        // '0' is always the value for the last element
        // we count how many 1 before the last 0
        // if the count is even, then there is no one could combine w/ the last 0, return true
        // else return false
        int count = 0;
        int i = bits.length - 2; // skip the last digit
        while( i >= 0 && bits[ i ] == 1 )
        {
            count++; i--;
        }
        return count % 2 == 0;
    }
}