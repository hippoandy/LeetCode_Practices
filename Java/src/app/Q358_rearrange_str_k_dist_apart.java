package app;

import java.util.*;

class Q358_rearrange_str_k_dist_apart
{
    public String rearrangeString(String s, int k)
    {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for( char c: s.toCharArray() ) count.put( c, count.getOrDefault( c, 0 ) + 1 );
        
        // max heap
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<Map.Entry<Character, Integer>>(
            (a, b) -> b.getValue() - a.getValue()
        );
        // build the max heap
        heap.addAll( count.entrySet() );
        
        // use a waitlist to pop 3 elements
        Queue<Map.Entry<Character, Integer>> waiting = new LinkedList<Map.Entry<Character, Integer>>();
        
        // the performance is better
        StringBuilder ans = new StringBuilder();
        while( !heap.isEmpty() )
        {
            Map.Entry<Character, Integer> pop = heap.remove();
            ans.append( pop.getKey() );
            pop.setValue( pop.getValue() - 1 );
            
            // put into the waitlist;
            waiting.offer( pop );
            
            if( waiting.size() < k ) continue;
            
            // pop the waitlist
            Map.Entry<Character, Integer> front = waiting.remove();
            // make sure the count is larger than 0
            if( front.getValue() > 0 ) heap.offer( front );
        }
        return ans.length() == s.length() ? ans.toString() : "";
    }
}
