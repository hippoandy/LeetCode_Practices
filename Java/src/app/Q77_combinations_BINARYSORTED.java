package app;

import java.util.*;

// Runtime: 5 ms, faster than 83.40% of Java online submissions for Combinations.
// Memory Usage: 39.2 MB, less than 70.80% of Java online submissions for Combinations.
class Q77_combinations_BINARYSORTED
{
    public List<List<Integer>> combine(int n, int k)
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for( int i = 1; i < k+1; i++ ) nums.add( i );
        // add a sentinel
        nums.add( n+1 );
        
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while( j < k )
        {
            // add current combination
            output.add( new ArrayList<Integer>( nums.subList( 0, k ) ) );
            // increase first num[ j ] by 1
            // find the 1st number if nums[ j ] + 1 != nums[ j + 1 ]
            j = 0;
            while( j < k && nums.get( j+1 ) == nums.get( j )+1 )
            {
                nums.set( j, j+1 );
                j++;
            }
            nums.set( j, nums.get(j) + 1 );
        }
        
        return output;
    }
}