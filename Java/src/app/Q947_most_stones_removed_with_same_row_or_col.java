// ref. https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/209369/Java-recursive-DFS-Short-and-easy-to-understand
// ref. https://www.jianshu.com/p/30d2058db7f7

package app;

import java.util.*;

// Runtime: 127 ms, faster than 8.50% of Java online submissions for Most Stones Removed with Same Row or Column.
// Memory Usage: 44.4 MB, less than 57.08% of Java online submissions for Most Stones Removed with Same Row or Column.
class Q947_most_stones_removed_with_same_row_or_col
{
    int m, n;
    public int removeStones(int[][] stones)
    {
        int numOfIsland = 0;
        Set<int[]> visited = new HashSet<int[]>();
        for( int[] s: stones )
            if( !visited.contains( s ) )
            {
                dfs( stones, s, visited );
                numOfIsland++;
            }
        return stones.length - numOfIsland;
    }
    
    private void dfs( int[][] stones, int[] cur, Set<int[]> visited )
    {
        visited.add( cur );
        for( int[] s: stones )
            // find neighbors
            if( !visited.contains( s ) )
            {
                // share a common row or column
                if( s[ 0 ] == cur[ 0 ] || s[ 1 ] == cur[ 1 ] )
                    dfs( stones, s, visited );
            }
    }
}