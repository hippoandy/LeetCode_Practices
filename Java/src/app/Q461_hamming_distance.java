// ref. https://leetcode.com/problems/hamming-distance/discuss/94698/Java-1-Line-Solution-%3AD
// ref. [XOR] https://logic.ly/lessons/xor-gate/

package app;

class Q461_hamming_distance
{
    public int hammingDistance(int x, int y)
    {
        int result = 0;
        while( x + y != 0 )
        {
            // What does come to your mind first when you see this sentence "corresponding bits are different"?
            // XOR!
            result += (x%2 ^ y%2);
            x >>= 1;
            y >>= 1;
        }
        return result;
    }
}