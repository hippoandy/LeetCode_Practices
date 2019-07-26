package app;

// Runtime: 174 ms, faster than 5.35% of Java online submissions for Subarray Sum Equals K.
// Memory Usage: 38.3 MB, less than 99.31% of Java online submissions for Subarray Sum Equals K.
class Q560_subarr_sum_equals_k
{
    int ans = 0;
    public int subarraySum(int[] nums, int k)
    {
        int count = 0;
        for( int s = 0; s < nums.length; s++ )
        {
            int sum = 0;
            for( int e = s; e < nums.length; e++ )
            {
                sum += nums[ e ];
                if( sum == k ) count++;
            }
        }
        return count;
    }
}