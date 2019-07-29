// ref. https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments.

package app;

class Q334_increasing_triplet_subsequence
{
    public boolean increasingTriplet(int[] nums)
    {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        
        for( int n: nums )
        {
            if( n <= small )
                small = n;
            else if( n <= big )
                big = n;
            else
                return true;
        }
        return false;
    }

//     // solve for continuous subarray
//     public boolean increasingTriplet(int[] nums)
//     {
//         if( nums == null ) return false;
//         if( nums.length <= 2 ) return false;

//         int[] dp = new int[ nums.length ];
//         dp[ 0 ] = 1;
//         for( int i = 1; i < nums.length; i++ )
//         {
//             dp[ i ] = (nums[ i ] > nums[ i - 1]) ? dp[ i-1 ] + 1 : 1;
//             if( dp[ i ] == 3 )
//                 return true;
//         }
//         return false;
//     }
}