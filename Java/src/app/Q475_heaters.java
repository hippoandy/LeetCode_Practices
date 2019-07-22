// ref. https://leetcode.com/problems/heaters/discuss/95886/Short-and-Clean-Java-Binary-Search-Solution
// ref. [JAVA Arrays.binarySearch()] https://www.geeksforgeeks.org/arrays-binarysearch-java-examples-set-1/

package app;

import java.util.*;

class Q475_heaters
{
    public int findRadius(int[] houses, int[] heaters)
    {
        Arrays.sort( heaters );
        int radius = Integer.MIN_VALUE;
        
        for( int house: houses )
        {
            int idx = Arrays.binarySearch( heaters, house );
            // the function will return (-(insertion point) – 1) if the key is not found
            // The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key
            // Therefore, for this question, we need heaters[] to be sorted!
            // the key is not found
            if( idx < 0 ) idx = -(idx + 1); // reverse and find teh insertion point
            
            // calculate the distances between this house and left heater and right heater
            int left = idx - 1 >= 0 ? house - heaters[ idx - 1 ] : Integer.MAX_VALUE;
            int right = idx < heaters.length ? heaters[ idx ] - house: Integer.MAX_VALUE;
            
            // get a MIN value for both the two values then,
            // get MAX value among distances, it's the answer.
            // since the heater should have the houses covered
            radius = Math.max( radius, Math.min( left, right ) );
        }
        return radius;
    }
}