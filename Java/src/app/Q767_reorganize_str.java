package app;

import java.util.*;

class Q767_reorganize_str
{
    public String reorganizeString(String s)
    {
        int[] count = new int[ 26 ];
        // get the occurence of a char
        for( char c: s.toCharArray() ) count[ c - 'a' ]++;
        
        // max-heap
        PriorityQueue<Entry> pq = new PriorityQueue<Entry>(
            (a, b) -> a.count == b.count ? a.letter - b.letter : b.count - a.count
        );
        
        // if N is the length of the string, and the count of some letter is greater than (N+1) / 2,
        // the task is impossible.
        for( int i = 0; i < 26; i++ )
        {
            int occurence = count[ i ];
            if( occurence > 0 )
            {
                // invalid!!
                if( occurence > (s.length() + 1) / 2 ) return "";
                pq.offer( new Entry( (char) ('a' + i), occurence ) );
            }
        }
        
        String ans = "";
        
        while( pq.size() >= 2 )
        {
            Entry a = pq.remove();
            Entry b = pq.remove();
            
            ans += a.letter;
            ans += b.letter;
            
            // put back to heap
            if( --a.count > 0 ) pq.offer( a );
            if( --b.count > 0 ) pq.offer( b );
        }
        // get the final letter if any
        if( pq.size() > 0 ) ans += pq.remove().letter;
        return ans.toString();
    }
    
    private class Entry
    {
        char letter;
        int count;
        
        public Entry( char c, int count ) { this.letter = c; this.count = count; }
    }
}