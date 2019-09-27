// ref. [SOLUTION] https://leetcode.com/problems/contains-duplicate-iii/discuss/61655/Java-O(N-lg-K)-solution
// ref. [Java TreeSet] https://www.geeksforgeeks.org/treeset-in-java-with-examples/

package app;

import java.util.*;

class Q220_contains_dup_3
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if( nums == null ) return false;
        if( nums.length < 2 || k <= 0 ) return false;

        TreeSet<Long> set = new TreeSet<Long>();

        for( int i = 0; i < nums.length; i++ )
        {
            long num = (long) nums[ i ];

            Long floor = set.floor( num );
            Long  ceil = set.ceiling( num );

            // check the valuse first
            if(
                (floor != null && num - floor <= t) ||
                (ceil != null && ceil - num <= t)
            )
                return true;

            set.add( num );

            // because we check the find the value first, then delete the oldest one
            // so the oldest one should be deleted at the previous iteration
            if( i >= k )
                set.remove( (long) nums[ i-k ] );
        }
        
        return false;
    }
}