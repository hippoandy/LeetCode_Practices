// ref. https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B
// [JAVA System.arraycopy()] https://www.geeksforgeeks.org/system-arraycopy-in-java/

package app;

import java.util.*;

class Q332_reconstruct_itinerary
{
    // use a queue to store the destinations
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
}