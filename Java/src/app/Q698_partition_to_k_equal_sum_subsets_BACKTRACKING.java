// ref. https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/JavaC%2B%2BStraightforward-dfs-solution
// ref. https://www.geeksforgeeks.org/partition-set-k-subsets-equal-sum/

package app;

// Runtime: 4 ms, faster than 55.54% of Java online submissions for Partition to K Equal Sum Subsets.
// Memory Usage: 34.3 MB, less than 87.50% of Java online submissions for Partition to K Equal Sum Subsets.
class Q698_partition_to_k_equal_sum_subsets_BACKTRACKING
{
    public boolean canPartitionKSubsets(int[] nums, int k)
    {
        int sum = 0;
        for( int x: nums ) sum += x;
        if( k <= 0 || sum % k != 0 ) return false;
        
        return backtracking( nums, new boolean[ nums.length ], k, 0, sum/k, 0 );
    }

    boolean backtracking( int[] a, boolean[] seen, int k, int sum, int tar, int start )
    {
        // if K is 1, then complete array will be our answer
        if( k == 1 ) return true;
        
        // Q: Why we need to recurse on partions of k-1 size
        //    if we are already at partition k and sum == target?
        //
        // A: Our goal is to get k sums, such that each sum=target.
        //    So each time we see sum=target, we reduce target by one and recurse.
        //
        // A: When we reach the point where subset sum is == target,
        //    we have found one of the subsets. So we perform k-1.
        //    But now we want to find out if the remaining numbers can form k-1 subsets.
        //    So we reset the index to zero. And start recursing again.
        //
        if( sum == tar )
            return backtracking( a, seen, k-1, 0, tar, 0 );

        for( int i = start; i < a.length; i++ )
            if( !seen[ i ] )
            {
                seen[ i ] = true;
                if( backtracking( a, seen, k, sum+a[ i ], tar, i+1 ) )
                    return true;
                seen[ i ] = false;
            }
        return false;
    }
}