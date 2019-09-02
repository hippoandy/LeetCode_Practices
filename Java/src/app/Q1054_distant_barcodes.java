package app;

import java.util.*;

class Q1054_distant_barcodes
{
    public int[] rearrangeBarcodes(int[] barcodes)
    {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for( int i: barcodes ) count.put( i, count.getOrDefault( i, 0 ) + 1 );
        
        PriorityQueue<Entry> pq = new PriorityQueue<Entry>( (a, b) -> (
            a.count == b.count ? a.key - b.key : b.count - a.count
        ));
        
        // notes that it is guaranteed an answer exists
        for( int k: count.keySet() ) pq.offer( new Entry( k, count.get( k ) ) );
        
        int i = 0;
        while( pq.size() >= 2 )
        {
            Entry a = pq.remove(), b = pq.remove();
            // place the value
            barcodes[ i++ ] = a.key;
            barcodes[ i++ ] = b.key;
            
            if( --a.count > 0 ) pq.offer( a );
            if( --b.count > 0 ) pq.offer( b );
        }
        // make sure there is nothing left
        if( !pq.isEmpty() ) barcodes[ i++ ] = pq.remove().key;
        return barcodes;
    }
    
    private class Entry
    {
        int key;
        int count;
        public Entry( int k, int v ) { this.key = k; this.count = v; }
    }
}