// ref. https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

package app;

import java.util.*;

class Q90_subsets_2
{
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sorted the array to allow the duplicates be detected!
        Arrays.sort( nums );
        backtracking( nums, ans, new ArrayList<Integer>(), nums.length, 0 );
        return ans;
    }
    
    private void backtracking( int[] nums, List<List<Integer>> ans, List<Integer> tmp, int len, int start )
    {
        ans.add( new ArrayList<Integer>( tmp ) );
        for( int i = start; i < len; i++ )
        {
            // skip duplicates, the array should be sorted!
            if( i > start && nums[ i ] == nums[ i-1 ] ) continue;
            tmp.add( nums[ i ] );
            backtracking( nums, ans, tmp, len, i+1 );
            tmp.remove( tmp.size() - 1 );
        }
    }
}