// ref. https://leetcode.com/problems/course-schedule/discuss/58509/C%2B%2B-BFSDFS

package app;

import java.util.*;

// Runtime: 269 ms, faster than 5.00% of Java online submissions for Course Schedule.
// Memory Usage: 55.2 MB, less than 17.15% of Java online submissions for Course Schedule.
class Q207_course_schedule_DFS
{
    // detecting a cycle in the directed graph!!
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        if( prerequisites == null ) return false;
        
        // step 1: construct the graph (adjacent list)
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for( int[] pair: prerequisites )
        {
            if( !graph.containsKey( pair[ 0 ] ) )
            {
                List<Integer> neighbor = new ArrayList<Integer>();
                neighbor.add( pair[ 1 ] );
                graph.put( pair[ 0 ], neighbor );
            }
            else
                graph.get( pair[ 0 ] ).add( pair[ 1 ] );
        }
        
        // step 2: dfs
        Set<Integer> visited = new HashSet<Integer>();
        for( Integer cur: graph.keySet() )
            if( dfs( graph, visited, cur, false ) )
                return false;
        
        return true;
    }
    
    private boolean dfs( Map<Integer, List<Integer>> graph, Set<Integer> visited, int cur, boolean cycleDetected )
    {
        // base case
        if( cycleDetected ) return true;
        else if( visited.contains( cur ) ) return true;
        
        // mark as visited
        visited.add( cur );
        // visit the neighbor
        List<Integer> neighbor = graph.get( cur );
        if( neighbor != null )
        {
            for( Integer n: neighbor )
                if( dfs( graph, visited, n, false ) )
                    return true;
        }
        // restore
        visited.remove( cur );
        return false;
    }
}