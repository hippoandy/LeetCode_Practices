package app;

import java.util.*;

class Q210_course_schedule_2
{
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        if( numCourses < 0 ) return new int[ 0 ];
        
        int[] indegree = new int[ numCourses ];
        
        // build the graph (adjacent list)
        // if b is a prerequisite of a, edge = b -> a!!
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for( int[] pair: prerequisites )
        {
            // pair[ 1 ] = b, pair[ 0 ] = a, edge => pair[ 1 ] -> pair[ 0 ]
            if( !graph.containsKey( pair[ 1 ] ) )
            {
                List<Integer> neighbor = new ArrayList<Integer>();
                neighbor.add( pair[ 0 ] );
                graph.put( pair[ 1 ], neighbor );
            }
            else
                graph.get( pair[ 1 ] ).add( pair[ 0 ] );
            // count how many incoming edges for each node
            indegree[ pair[ 0 ] ]++;
        }

        // the ans, result of the topological sort
        int[] courses = new int[ numCourses ];
        
        Queue<Integer> q = new LinkedList<Integer>();
        // add all the node with indegree 0 in to the queue as start point
        for( int i = 0; i < indegree.length; i++ )
            if( indegree[ i ] == 0 )
                q.offer( i );
        
        // start the topological sort
        int i = 0;
        while( !q.isEmpty() )
        {
            int node = q.remove();
            // put it into the list of courses
            courses[ i ] = node;
            
            if( graph.containsKey( node ) )
            {
                // reduce the in-degree of each neighbor by 1
                for( int neighbor: graph.get( node ) )
                {
                    indegree[ neighbor ]--;
                    // if in-degree of a neighbor becomes 0, add it to the queue
                    if( indegree[ neighbor ] == 0 )
                        q.offer( neighbor );
                }
            }
            i++;
        }
        
        if( i == numCourses )
            return courses;
        else
            return new int[ 0 ];
    }
}