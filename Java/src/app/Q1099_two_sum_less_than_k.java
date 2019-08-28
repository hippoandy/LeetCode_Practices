// ref. https://leetcode.com/problems/two-sum-less-than-k/discuss/322931/Java-Sort-then-push-from-two-ends.

package app;

import java.util.*;

class Q1099_two_sum_less_than_k
{
    public int twoSumLessThanK(int[] A, int K)
    {
        if( A == null || A.length == 0 ) return -1;

        // sort the array
        Arrays.sort( A );
        
        int max = -1;
        // binary search
        int i = 0, j = A.length - 1;
        while( i < j )
        {
            int sum = A[ i ] + A[ j ];
            if( sum < K )
            {
                max = Math.max( max, sum );
                i++;
            }
            else j--;
        }
        return max;
    }
}