package app;

import java.util.*;

class Q599_min_idx_sum_of_2_lists
{
    public String[] findRestaurant(String[] list1, String[] list2)
    {
        if( list1 == null || list1.length == 0 ) return new String[ 1 ];
        if( list2 == null || list2.length == 0 ) return new String[ 1 ];

        // record the index
        Map<String, Integer> andy = new HashMap<String, Integer>();
        for( int i = 0; i < list1.length; i++ ) andy.put( list1[ i ], i );

        List<String> res = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        for( int i = 0; i < list2.length; i++ )
            if( andy.containsKey( list2[ i ] ) )
            {
                // compute the index sum
                int idxSum = andy.get( list2[ i ] ) + i;
                if( idxSum < min )
                {
                    // remember to clear the previous result here!
                    res.clear();
                    min = idxSum;
                    res.add( list2[ i ] );
                }
                // if there is a choice tie between answers, output all of them
                else if( idxSum == min )
                    res.add( list2[ i ] );
            }
        return res.toArray( new String[ res.size() ] );
    }
}