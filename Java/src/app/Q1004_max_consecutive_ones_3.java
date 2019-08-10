// ref. https://leetcode.com/problems/max-consecutive-ones-iii/discuss/247564/JavaC%2B%2BPython-Sliding-Window

package app;

/* Algorithm:
    The idea is to keep a window [l, h] that contains at most k zero
    If A[i] ~ A[j] has zeros <= K, we continue to increment j.
    If A[i] ~ A[j] has zeros > K, we increment i.
 */
class Q1004_max_consecutive_ones_3
{
    public int longestOnes(int[] A, int K)
    {
        int i = 0, j = 0;
        for( j = 0; j < A.length; j++ )
        {
            if( A[ j ] == 0 ) K--;
            if( K < 0 )
            {
                if( A[ i ] == 0 ) K++;
                i++;
            }
        }
        return j - i;
    }
}