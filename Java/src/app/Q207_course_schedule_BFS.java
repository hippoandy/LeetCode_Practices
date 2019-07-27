package app;

import java.util.*;

// Runtime: 32 ms, faster than 26.84% of Java online submissions for Course Schedule.
// Memory Usage: 44.9 MB, less than 84.97% of Java online submissions for Course Schedule.
class Q207_course_schedule_BFS
{
    // detecting a cycle in the directed graph!!
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        if( prerequisites == null ) return false;
        int[] indegree = new int[ numCourses ];
        
        Queue<Integer> q = new LinkedList<Integer>();
        for( int[] pair: prerequisites )
            // record total num of courses that depends on the curr course
            indegree[ pair[ 1 ] ]++;
        // find all the courses that not holds a prerequisites
        // why this works? Total of n courses, labeled from 0 to n-1!
        for( int i = 0; i < indegree.length; i++ )
            if( indegree[ i ] == 0 )
                q.offer( i );
        // perform breadth-first search
        while( !q.isEmpty() )
        {
            numCourses--;
            int course = q.remove();
            for( int[] pair: prerequisites )
            {
                if( pair[ 0 ] == course )
                {
                    indegree[ pair[ 1 ] ]--;
                    // the course now don't have any prerequisites
                    if( indegree[ pair[ 1 ] ] == 0 )
                        q.offer( pair[ 1 ] );
                }
            }
        }
        return numCourses == 0;
    }
}

// class Solution
// {
//     // detecting a cycle in the directed graph!!
//     public boolean canFinish(int numCourses, int[][] prerequisites)
//     {
//         if( prerequisites == null ) return false;
        
//         // step 1: construct the graph (adjacent list)
//         Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
//         for( int[] pair: prerequisites )
//         {
//             if( !graph.containsKey( pair[ 0 ] ) )
//             {
//                 List<Integer> neighbor = new ArrayList<Integer>();
//                 neighbor.add( pair[ 1 ] );
//                 graph.put( pair[ 0 ], neighbor );
//             }
//             else
//                 graph.get( pair[ 0 ] ).add( pair[ 1 ] );
//         }
        
//         // step 2: dfs
//         Set<Integer> visited = new HashSet<Integer>();
//         for( Integer cur: graph.keySet() )
//             if( dfs( graph, visited, cur, false ) )
//                 return false;
        
//         return true;
//     }
    
//     private boolean dfs( Map<Integer, List<Integer>> graph, Set<Integer> visited, int cur, boolean cycleDetected )
//     {
//         // base case
//         if( cycleDetected ) return true;
//         else if( visited.contains( cur ) ) return true;
        
//         // mark as visited
//         visited.add( cur );
//         // visit the neighbor
//         List<Integer> neighbor = graph.get( cur );
//         if( neighbor != null )
//         {
//             for( Integer n: neighbor )
//                 if( dfs( graph, visited, n, false ) )
//                     return true;
//         }
//         // restore
//         visited.remove( cur );
//         return false;
//     }
// }