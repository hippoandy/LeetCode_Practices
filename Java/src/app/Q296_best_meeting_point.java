// ref. https://leetcode.com/problems/best-meeting-point/discuss/74186/14ms-java-solution

package app;

import java.util.*;

class Q296_best_meeting_point
{
    // since it's "Manhattan Distance": find the median for each dimension and |x - median| it will be the answer!
    // see: https://math.stackexchange.com/questions/113270/the-median-minimizes-the-sum-of-absolute-deviations-the-l-1-norm
    public int minTotalDistance(int[][] grid)
    {
        if( grid == null || grid.length == 0 ) throw new IllegalArgumentException( "Empty grid!" );
        
        List<Integer> X = new ArrayList<Integer>();
        List<Integer> Y = new ArrayList<Integer>();
        for( int i = 0; i < grid.length; i++ )
            for( int j = 0; j < grid[ i ].length; j++ )
                if( grid[ i ][ j ] == 1 )
                {
                    X.add( i ); Y.add( j );
                }
        return getMin( X ) + getMin( Y );
    }
    
    private int getMin( List<Integer> nums )
    {
        // sort the list
        Collections.sort( nums );
        // find the median
        int median = nums.get( nums.size() / 2 );
        int dist = 0;
        for( int x: nums )
            dist += Math.abs( x - median );
        return dist;
    }
}