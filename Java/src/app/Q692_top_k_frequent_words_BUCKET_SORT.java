// ref. https://leetcode.com/problems/top-k-frequent-words/discuss/232790/Bucket-sort-beat-99-java

package app;

import java.util.*;

// Runtime: 6 ms, faster than 96.40% of Java online submissions for Top K Frequent Words.
// Memory Usage: 38.7 MB, less than 67.86% of Java online submissions for Top K Frequent Words.
class Q692_top_k_frequent_words_BUCKET_SORT
{
    public List<String> topKFrequent(String[] words, int k)
    {
        // frequency map
        Map<String, Integer> map = new HashMap<String, Integer>();
        for( String s : words )
            map.put( s, map.getOrDefault( s, 0 ) + 1 );
        
        List<String>[] bucket = new List[ words.length + 1 ];
        for( String s: map.keySet() )
        {
            int freq = map.get( s );
            if( bucket[ freq ] == null ) bucket[ freq ] = new ArrayList<String>();
            bucket[ freq ].add( s );
        }
        
        List<String> ans = new ArrayList<String>();
        for( int i = bucket.length-1; i >= 0 && ans.size() < k; i-- )
        {
            if( bucket[ i ] == null ) continue;
            Collections.sort( bucket[ i ] );
            ans.addAll( bucket[ i ] );
        }
        return ans.size() == k ? ans: ans.subList( 0, k );
    }
}