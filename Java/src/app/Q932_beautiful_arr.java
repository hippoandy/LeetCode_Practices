// ref. https://leetcode.com/problems/beautiful-array/discuss/186679/Odd-%2B-Even-Pattern-O(N)

package app;

import java.util.*;

class Q932_beautiful_arr
{
    public int[] beautifulArray(int N)
    {
        // odd/even pattern
        List<Integer> ans = new LinkedList<Integer>();
        // number range from 1 ...... N
        ans.add( 1 );
        
        while( ans.size() < N )
        {
            List<Integer> tmp = new LinkedList<Integer>();
            // odd
            for( int i: ans ) if( i*2-1 <= N ) tmp.add( i*2-1 );
            // even
            for( int i: ans ) if( i*2 <= N )   tmp.add( i*2 );
            ans = tmp;
        }
        return ans.stream().mapToInt( i -> i ).toArray();
    }
}