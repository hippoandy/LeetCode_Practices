// ref. https://leetcode.com/problems/pancake-sorting/discuss/214213/JavaC%2B%2BPython-Straight-Forward
// [PANCAKE SORT PAPER] https://people.eecs.berkeley.edu/~christos/papers/Bounds%20For%20Sorting%20By%20Prefix%20Reversal.pdf

package app;

import java.util.*;

class Q969_pancake_sorting
{
    public List<Integer> pancakeSort(int[] A)
    {
        List<Integer> res = new ArrayList<>();
        // element range from [ 1...A.length ]!!
        for( int x = A.length; x > 0; x-- )
        {
            // 1. find the next maximum number
            int i = 0;
            for( ; i < A.length; i++ )
                if( A[ i ] == x ) break;

            // 2. reverse i+1 nums, so x will be at A[ 0 ]
            reverse( A, i+1 );
            res.add( i+1 );

            // 3. revers x nums, so x will be at A[ x-1 ]
            reverse( A, x );
            res.add( x );
        }
        return res;
    }

    public void reverse( int[] A, int k )
    {
        int i = 0, j = k-1;
        while( i < j )
        {
            int tmp = A[ i ];
            A[ i ] = A[ j ];
            A[ j ] = tmp;
            
            i++;
            j--;
        }
    }
}