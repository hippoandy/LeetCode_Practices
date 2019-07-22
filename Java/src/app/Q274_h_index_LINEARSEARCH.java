// refer to the solution for Q275

package app;

import java.util.*;

// O(nlogn)
class Q274_h_index_LINEARSEARCH
{
    public int hIndex(int[] citations)
    {
        Arrays.sort( citations );
        int idx = 0, n = citations.length;
        for( int c: citations )
        {
            if( c >= n - idx ) return n - idx;
            idx++;
        }
        return 0;
    }
}