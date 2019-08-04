// ref. https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC%2B%2B-Simple-greedy-like-solution-with-explanation

package app;

// Runtime: 1 ms, faster than 99.67% of Java online submissions for Non-decreasing Array.
// Memory Usage: 47 MB, less than 5.96% of Java online submissions for Non-decreasing Array.
class Q665_non_decreasing_arr
{
    public boolean checkPossibility(int[] nums)
    {
        //the number of changes
        int cnt = 0;
        for( int i = 1; i < nums.length; i++ )
        {
            if( nums[ i-1 ] > nums[ i ] )
            {
                cnt++;
                // modify nums[ i-1 ] of a priority
                if( i-2 < 0 || nums[ i-2 ] <= nums[ i ] ) nums[ i-1 ] = nums[ i ];
                // have to modify nums[ i ]
                else nums[ i ] = nums[ i-1 ];
            }
        }
        return cnt <= 1; 
    }
}