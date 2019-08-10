package app;

/* Algorithm:
    The idea is to keep a window [l, h] that contains at most k zero
    If A[i] ~ A[j] has zeros <= K, we continue to increment j.
    If A[i] ~ A[j] has zeros > K, we increment i.
    Where K == 1
    Refer to Q1004
 */
class Q487_max_consecutive_ones_2
{
    public int findMaxConsecutiveOnes(int[] nums)
    {
        int k = 1, i = 0, j = 0;
        for( j = 0; j < nums.length; j++ )
        {
            if( nums[ j ] == 0 ) k--;
            if( k < 0 )
            {
                if( nums[ i ] == 0 ) k++;
                i++;
            }
        }
        return j - i;
    }
}