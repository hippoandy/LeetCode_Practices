package app;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Q15_3sum
{
    // two pointers
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        if( nums == null || nums.length < 2 ) return sol;
        
        // sort the input array
        Arrays.sort( nums );
        
        // i + 2 is to make sure there are at least 3 elements
        for( int i = 0; i + 2 < nums.length; i++ )
        {
            if( i > 0 && nums[ i ] == nums[ i-1 ] ) continue;

            // since the target is zero
            // choose the current i as one of the selected element
            int target = -nums[ i ];

            // find the solution between i+1 ~ n-1
            int l = i+1, r = nums.length-1;
            while( l < r )
            {
                // found a solution
                if( target == nums[ l ] + nums[ r ] )
                {
                    sol.add( Arrays.asList( nums[ i ], nums[ l ], nums[ r ] ) );
                    l++;
                    r--;
                    
                    // prevent using the same number as target
                    // that's why the array should be sorted beforehand
                    while( l < r && nums[ l ] == nums[ l - 1 ] ) l++;
                    while( l < r && nums[ r ] == nums[ r + 1 ] ) r--;
                }
                // the sum is too big, substract the right pointer
                else if( nums[ l ] + nums[ r ] > target ) r--;
                // the sum is too small, increase the left pointer
                else l++;
            }
        }
        return sol;
    }
}