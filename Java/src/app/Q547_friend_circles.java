package app;

import java.util.*;


// Runtime: 6 ms, faster than 24.59% of Java online submissions for Friend Circles.
// Memory Usage: 45.7 MB, less than 39.50% of Java online submissions for Friend Circles.
class Q547_friend_circles
{
    public int findCircleNum(int[][] M)
    {
        if( M == null ) return 0;
        // Given a N * N matrix M
        int n = M.length;
        
        // build the graph
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for( int i = 0; i < n; i++ )
            for( int j = 0; j < n; j++ )
            {
                if( i == j ) continue;
                if( M[ i ][ j ] == 1 )
                {
                    if( !graph.containsKey( i ) )
                        graph.put( i, new ArrayList<Integer>() );
                    graph.get( i ).add( j );
                }
            }
        
        int count = 0;
        boolean[] visited = new boolean[ n ];
        for( int i = 0; i < n; i++ )
            if( !visited[ i ] )
            {
                count++;
                dfs( graph, visited, i );
            }
        return count;
    }
    
    private void dfs( Map<Integer, List<Integer>> graph, boolean[] visited, int start )
    {
        if( visited[ start ] ) return;
        visited[ start ] = true;
        if( graph.containsKey( start ) )
            for( int f: graph.get( start ) )
                dfs( graph, visited, f );
    }
}