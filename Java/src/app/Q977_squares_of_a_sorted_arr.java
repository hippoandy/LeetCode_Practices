package app;

import java.util.*;

class Q977_squares_of_a_sorted_arr
{
    // brute-froce
    public int[] sortedSquares(int[] A)
    {
        for( int i = 0; i < A.length; i++ ) A[ i ] *= A[ i ];
        Arrays.sort( A );
        return A;
    }
}