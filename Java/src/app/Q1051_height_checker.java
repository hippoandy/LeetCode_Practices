// ref. [JAVA ARRAY COPY] https://www.geeksforgeeks.org/array-copy-in-java/

package app;

import java.util.*;

// Hint: Build the correct order of heights by sorting another array, then compare the two arrays.
class Q1051_height_checker
{
    public int heightChecker(int[] heights)
    {
        int[] toCompare = heights.clone();
        Arrays.sort( toCompare );
        
        int count = 0;
        for( int i = 0; i < heights.length; i++ )
            if( toCompare[ i ] != heights[ i ] ) count++;
        return count;
    }
}