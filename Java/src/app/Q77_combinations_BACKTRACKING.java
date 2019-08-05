package app;

import java.util.*;

// Runtime: 26 ms, faster than 55.16% of Java online submissions for Combinations.
// Memory Usage: 41.4 MB, less than 10.58% of Java online submissions for Combi
class Q77_combinations_BACKTRACKING
{
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( k > n ) return ans;
        if( n < 0 ) return ans;

        backtracking( ans, new ArrayList<Integer>(), n, k, 0 );
        return ans;
    }
    
    private void backtracking( List<List<Integer>> ans, List<Integer> tmp, int n, int k, int chosen )
    {
        if( tmp.size() == k )
            ans.add( new ArrayList<Integer>( tmp ) );
        else
        {
            for( int i=chosen+1; i <= n; i++ )
            {
                tmp.add( i );
                backtracking( ans, tmp, n, k, i );
                tmp.remove( tmp.size()-1 );
            }
        }
    }
}