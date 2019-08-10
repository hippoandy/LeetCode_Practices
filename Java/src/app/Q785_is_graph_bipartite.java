// ref. [Bipartiteness] https://www.geeksforgeeks.org/bipartite-graph/
// ref. [SOLUTION] https://leetcode.com/problems/is-graph-bipartite/discuss/115503/java-BFS

package app;

import java.util.*;

class Q785_is_graph_bipartite
{
    public boolean isBipartite(int[][] graph)
    {
        int[] color = new int[ graph.length ];
        // init the color, "-1" as un-colored
        Arrays.fill( color, -1 );

        // think about if the start point doesn't have out going edge!
        for( int i = 0; i < graph.length; i++ )
            if( graph[ i ].length != 0 && color[ i ] == -1 )
            {
                Queue<Integer> q = new LinkedList<Integer>();
                q.offer( i );
                color[ i ] = 1;
                while( !q.isEmpty() )
                {
                    int cur = q.remove();
                    for( int n: graph[ cur ] )
                    {
                        // self-loop
                        if( n == cur ) return false;

                        // no color assigned yet
                        if( color[ n ] == -1 )
                        {
                            // assign alternate color to this adjacent n of cur
                            color[ n ] = 1 - color[ cur ];
                            q.offer( n );
                        }
                        // the neighbor of cur shouldn't have the same color
                        else if( color[ n ] == color[ cur ] )
                            return false;
                    }
                }
            }
        return true;
    }
}