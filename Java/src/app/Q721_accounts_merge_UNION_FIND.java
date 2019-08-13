package app;

import java.util.*;

// Runtime: 66 ms, faster than 27.43% of Java online submissions for Accounts Merge.
// Memory Usage: 44.4 MB, less than 100.00% of Java online submissions for Accounts Merge.
class Q721_accounts_merge_UNION_FIND
{
    public List<List<String>> accountsMerge( List<List<String>> accounts )
    {
        Map<String, String> accToName = new HashMap<String, String>();
        Map<String, Integer> accToID = new HashMap<String, Integer>();

        // disjoint set union object
        DSU dsu = new DSU();

        int id = 0;
        for( List<String> acc: accounts )
        {
            String name = "";
            for( String email: acc )
            {
                if( name.equals( "" ) )
                {   // first element is the name
                    name = email;
                    continue;
                }
                // account and name association
                accToName.put( email, name );
                
                if( !accToID.containsKey( email ) )
                    accToID.put( email, id++ );
                dsu.union( accToID.get( acc.get( 1 ) ), accToID.get( email ) );
            }
        }
        
        // compute the result
        Map<Integer, List<String>> ans = new HashMap<Integer, List<String>>();
        for( String email: accToName.keySet() )
        {
            int idx = dsu.find( accToID.get( email ) );
            ans.computeIfAbsent( idx, x -> new ArrayList<String>() ).add( email );
        }
        // sort the result
        for( List<String> tmp: ans.values() )
        {
            Collections.sort( tmp );
            tmp.add( 0, accToName.get( tmp.get( 0 ) ) );
        }
        return new ArrayList<List<String>>( ans.values() );
    }
    
    class DSU
    {
        int[] parent;
        public DSU()
        {
            parent = new int[ 10001 ];
            for( int i = 0; i < 10001; i++ )
                parent[ i ] = i;
        }
        // find the parent of the connected component the index belongs to
        public int find( int x )
        {
            // path compression
            if( parent[ x ] != x ) parent[ x ] = find( parent[ x ] );
            return parent[ x ];
        }
        // get the parent idx of y and assign to x as its parent
        public void union( int x, int y )
        {
            parent[ find( x ) ] = find( y );
        }
    }
}