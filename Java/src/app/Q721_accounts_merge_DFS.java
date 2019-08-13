package app;

import java.util.*;

// Runtime: 70 ms, faster than 21.00% of Java online submissions for Accounts Merge.
// Memory Usage: 45.9 MB, less than 58.82% of Java online submissions for Accounts Merge.
class Q721_accounts_merge_DFS
{
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> accToName = new HashMap<String, String>();
        Map<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        for( List<String> account: accounts )
        {
            String name = "";
            for( String email: account )
            {
                if( name == "" )
                {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent( email, x -> new ArrayList<String>() ).add( account.get(1) );
                graph.computeIfAbsent( account.get(1), x -> new ArrayList<String>() ).add( email );
                accToName.put(email, name);
            }
        }

        // dfs
        Set<String> visited = new HashSet<String>();
        List<List<String>> ans = new ArrayList<List<String>>();
        for( String email: graph.keySet() )
        {
            if( !visited.contains( email ) )
            {
                List<String> component = new ArrayList<String>();
                visited.add( email );

                Stack<String> stack = new Stack<String>();
                stack.push( email );
                while( !stack.isEmpty() )
                {
                    String node = stack.pop();
                    component.add( node );
                    for( String neighbor: graph.get( node ) )
                        // if not visited
                        if( visited.add( neighbor ) )
                            stack.push( neighbor );
                }
                Collections.sort( component );
                // append the name
                component.add( 0, accToName.get( email ) );
                ans.add( component );
            }
        }
        return ans;
    }
}