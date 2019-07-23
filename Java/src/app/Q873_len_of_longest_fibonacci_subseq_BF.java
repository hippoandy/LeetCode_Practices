package app;

import java.util.*;

// Runtime: 59 ms, faster than 75.80% of Java online submissions for Length of Longest Fibonacci Subsequence.
// Memory Usage: 38.7 MB, less than 96.20% of Java online submissions for Length of Longest Fibonacci Subsequence.
class Q873_len_of_longest_fibonacci_subseq_BF
{
    public int lenLongestFibSubseq(int[] A)
    {
        int N = A.length;
        Set<Integer> set = new HashSet<Integer>();
        for( int a: A ) set.add( a );
        
        int ans = 0;
        // need to start with every number to find the sequence
        for( int i = 0; i < N; i++ )
            for( int j = i + 1; j < N; j++ )
            {
                // x is the previous value in the Fibonacci-like seq, y is the next excepted value;
                int x = A[ j ], y = A[ i ] + A[ j ];
                // the initial value of len should be 2, since there are 2 nums in the seq already
                int len = 2;
                // since we stores all the num in set, just try to find the next expected value
                // if the value exists, len += 1
                while( set.contains( y ) )
                {
                    int tmp = y;
                    y += x;
                    x = tmp;
                    ans = Math.max( ans, ++len );
                }
            }
        return ans >= 3 ? ans : 0;
    }
}