// ref. https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort

package app;

import java.util.*;

class Q347_top_k_frequent_elements_BUCKETSORT
{
    public List<Integer> topKFrequent(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int i: nums ) map.put( i, map.getOrDefault( i, 0 ) + 1 );
        
        // store all number with the same freq
        List<Integer>[] bucket = new List[ nums.length+1 ];
        for( int key: map.keySet() )
        {
            if( bucket[ map.get( key ) ] == null ) bucket[ map.get( key ) ] = new ArrayList<Integer>();
            bucket[ map.get( key ) ].add( key );
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for( int i = bucket.length-1; i >= 0 && ans.size() <= k; i-- )
            if( bucket[ i ] != null )
                ans.addAll( bucket[ i ] );
        // make sure the list is within size k
        return ans.subList( 0, k );
    }
}