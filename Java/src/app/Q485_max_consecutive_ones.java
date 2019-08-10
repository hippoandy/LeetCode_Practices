package app;

class Q485_max_consecutive_ones
{
    public int findMaxConsecutiveOnes(int[] nums)
    {
        int max = 0, sum = 0;
        for( int i = 0; i < nums.length; i++ )
        {
            sum += nums[ i ];
            if( nums[ i ] == 0 )
                sum = 0;
            else
                max = (sum > max) ? sum : max;
        }
        return max;
    }
}