package app;

import java.util.*;

// Runtime: 4 ms, faster than 75.29% of Java online submissions for Alien Dictionary.
// Memory Usage: 36 MB, less than 97.30% of Java online submissions for Alien Dictionary.
class Q269_alien_dict_BFS
{
    public String alienOrder(String[] words)
    {
        // 1. build the graph && indregree array
        Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        buildGraph( graph, indegree, words );
        
        // get all the node with indegree 0
        Queue<Character> q = new LinkedList<Character>();
        for( char c: indegree.keySet() )
            if( indegree.get( c ) == 0 )
                q.offer( c );
        
        // 2. perform topological sort
        String res = "";
        while( !q.isEmpty() )
        {
            char cur = q.remove();
            res += cur;

            if( graph.containsKey( cur ) )
                for( char nei: graph.get( cur ) )
                {
                    indegree.put( nei, indegree.get( nei )-1 );
                    if( indegree.get( nei ) == 0 )
                        q.offer( nei );
                }
        }
        if( res.length() != indegree.size() ) return "";
        return res;
    }
    
    private void buildGraph( Map<Character, Set<Character>> graph, Map<Character, Integer> indegree, String[] words )
    {
        int n = words.length;
        for( int i = 0; i < n; i++ )
        {
            for( char c: words[ i ].toCharArray() )
                // init point
                if( !indegree.containsKey( c ) )
                    indegree.put( c, 0 );

            if( i > 0 )
            {
                String w1 = words[ i-1 ], w2 = words[ i ];
                int minlen = (w1.length() > w2.length()) ? w2.length() : w1.length();
                for( int j = 0; j < minlen; j++ )
                {
                    char c1 = w1.charAt( j ), c2 = w2.charAt( j );
                    if( c1 == c2 ) continue;
                    
                    Set<Character> set = new HashSet<Character>();
                    if( graph.containsKey( c1 ) ) set = graph.get( c1 );
                    // prevent duplicate edges
                    if( !set.contains( c2 ) )
                    {
                        set.add( c2 );
                        graph.put( c1, set );
                        indegree.put( c2, indegree.get( c2 )+1 );
                    }
                    // we can determine the order of characters only by first different pair of characters so we cannot add relationship by the rest of characters
                    break;
                }
            }
        }
    }
}