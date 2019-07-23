package app;

// see question 873

class Q300_longest_increasing_subsequence
{
    public int lengthOfLIS(int[] nums)
    {
        if( nums == null )     return 0;
        if( nums.length == 0 ) return 0;
        
        int N = nums.length;
        
        int[] dp = new int[ N ];
        dp[ 0 ] = 1;
        int max_len = 1;
        // index: 0 < i < j
        for( int j = 1; j < N; j++ )
        {
            int len = 0;
            for( int i = 0; i < j; i++ )
                if( nums[ j ] > nums[ i ] )
                    len = Math.max( len, dp[ i ] );

            dp[ j ] = len + 1;
            max_len = Math.max( max_len, dp[ j ] );
        }
        return max_len;
    }
}