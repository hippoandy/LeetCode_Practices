// ref. https://leetcode.com/problems/find-all-duplicates-in-an-array/discuss/92387/Java-Simple-Solution

package app;

import java.util.*;

class Q442_find_all_dups_in_an_arr
{
    // // Runtime: 4 ms, faster than 100.00% of Java online submissions for Find All Duplicates in an Array.
    // // Memory Usage: 50.8 MB, less than 36.11% of Java online submissions for Find All Duplicates in an Array.
    // public List<Integer> findDuplicates(int[] nums)
    // {
    //     List<Integer> ans = new ArrayList<Integer>();
    //     if( nums == null ) return ans;
    //     if( nums.length == 0 ) return ans;
        
    //     int[] count = new int[ nums.length + 1 ];
        
    //     for( int n: nums )
    //     {
    //         count[ n ] += 1;
    //         if( count[ n ] == 2 ) ans.add( n );
    //     }
    //     return ans;
    // }

    // NES
    // Runtime: 6 ms, faster than 89.55% of Java online submissions for Find All Duplicates in an Array.
    // Memory Usage: 47.5 MB, less than 91.67% of Java online submissions for Find All Duplicates in an Array.
    public List<Integer> findDuplicates(int[] nums)
    {
        List<Integer> ans = new ArrayList<Integer>();
        if( nums == null ) return ans;
        if( nums.length == 0 ) return ans;
        
        for( int i = 0; i < nums.length; i++ )
        {
            int idx = Math.abs( nums[ i ] ) - 1; // 0-index
            if( nums[ idx ] < 0 ) ans.add( Math.abs( idx ) + 1 );
            // flip the value as a marker
            nums[ idx ] = -nums[ idx ];
        }
        return ans;
    }
}