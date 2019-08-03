// ref. [SOLUTION] https://leetcode.com/problems/third-maximum-number/discuss/90209/Short-easy-C%2B%2B-using-set
// ref. [Java TreeSet] https://www.geeksforgeeks.org/treeset-in-java-with-examples/

package app;

import java.util.*;

class Q414_third_max_num
{
    public int thirdMax(int[] nums)
    {
        // TreeSet implement the sortedSet class in Java
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for( int n: nums )
        {
            set.add( n );
            if( set.size() > 3 ) set.remove( set.first() );
        }
        return (set.size() == 3) ? set.first() : set.last();
    }
}