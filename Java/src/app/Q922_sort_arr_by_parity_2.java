package app;

import java.util.*;

// Runtime: 7 ms, faster than 13.38% of Java online submissions for Sort Array By Parity II.
class Q922_sort_arr_by_parity_2
{
    public int[] sortArrayByParityII(int[] A)
    {
        Queue<Integer> even = new LinkedList<Integer>();
        Queue<Integer> odd = new LinkedList<Integer>();
        
        for( int n: A )
        {
            if( n % 2 == 0 ) even.offer( n );
            else odd.offer( n );
        }
        
        for( int i = 0; i < A.length; i++ )
        {
            if( i % 2 == 0 ) A[ i ] = even.remove();
            else A[ i ] = odd.remove();
        }
        
        return A;
    }
}