// ref. https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B
// [JAVA System.arraycopy()] https://www.geeksforgeeks.org/system-arraycopy-in-java/

package app;

import java.util.*;

class Q332_reconstruct_itinerary
{
    // use a priority queue to store the destinations
    // requirement: should return the itinerary that has the smallest lexical order
    Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
    List<String> route = new ArrayList<String>();

    public List<String> findItinerary(List<List<String>> tickets)
    {
        if( tickets == null ) return route;
        if( tickets.size() == 0 ) return route;

        for( List<String> t: tickets )
        {
            String dep = t.get( 0 );    // departure
            String arr = t.get( 1 );    // arrival
            // build the graph
            if( !graph.containsKey( dep ) )
                graph.put( dep, new PriorityQueue<String>() );
            graph.get( dep ).add( arr );
        }
        // All of the tickets belong to a man who departs from JFK
        visit( "JFK" );
        return route;
    }

    private void visit( String airport )
    {
        // when the departure airport has a destination exist
        while( graph.containsKey( airport ) && graph.get( airport ).size() != 0 )
            // the structure stores in the map is a queue
            // remove the element to prevent duplicate
            visit( graph.get( airport ).remove() );
        // insert from the head since the recursion, the last airport will be at the head
        route.add( 0, airport );
    }

    /* second version
    // Runtime: 37 ms, faster than 14.54% of Java online submissions for Reconstruct Itinerary.
    // Memory Usage: 40.7 MB, less than 79.10% of Java online submissions for Reconstruct Itinerary.
    public List<String> findItinerary(List<List<String>> tickets)
    {
        if( tickets == null ) return null;
        if( tickets.isEmpty() ) return null;
        
        // build the graph
        Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
        for( List<String> t: tickets )
        {
            String src = t.get( 0 ), dst = t.get( 1 );
            graph.computeIfAbsent( src, x -> new PriorityQueue<String>( new Comparator<String>()
            {   @Override
                public int compare( String a, String b )
                // return the itinerary that has the smallest lexical order
                { return a.compareTo( b ); }
            }) ).offer( dst );
        }

        List<String> order = new ArrayList<String>();
        // the itinerary must begin with "JFK"
        dfs( graph, order, "JFK" );

        return order;
    }
    
    private void dfs( Map<String, PriorityQueue<String>> graph, List<String> order, String src )
    {
        while( graph.containsKey( src ) && !graph.get( src ).isEmpty() )
            dfs( graph, order, graph.get( src ).remove() );
        order.add( 0, src );
    }
    */
}