package app;

import java.util.*;

class Q819_most_common_word_MAXHEAP
{
    public String mostCommonWord(String paragraph, String[] banned)
    {
        if( paragraph.length() <= 0 ) throw new IllegalArgumentException( "Paragraph is Null!" );

        Set<String> ban = new HashSet<String>( Arrays.asList( banned ) );        

        Map<String, Integer> map = new HashMap<String, Integer>();
        for( String w: paragraph.split( "[!?\\',;\\.\\s]" ) )
        {
            String lower = w.toLowerCase();
            if( lower.isEmpty() || lower.equals( " " ) || ban.contains( lower ) ) continue;
            map.put( lower, map.getOrDefault( lower, 0 ) + 1 );
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(
            (a, b) -> b.getValue() - a.getValue()
        );
        for( Map.Entry<String, Integer> e: map.entrySet() ) pq.offer( e );
        
        return pq.peek().getKey();
    }
}