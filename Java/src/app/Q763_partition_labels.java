package app;

import java.util.*;

class Q763_partition_labels
{
    public List<Integer> partitionLabels(String S)
    {
        int[] last = new int[ 26 ];
        for( int i = 0; i < S.length(); i++ )
            last[ S.charAt( i ) - 'a' ] = i;
        
        int anchor = 0, j = 0;
        List<Integer> ans = new ArrayList<Integer>();
        for( int i = 0; i < S.length(); i++ )
        {
            j = Math.max( j, last[ S.charAt( i ) - 'a' ] );
            if( i == j )
            {
                ans.add( i-anchor+1 );
                anchor = i + 1;
            }
        }
        return ans;
    }
}