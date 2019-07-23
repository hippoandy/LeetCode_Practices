package app;

import java.util.*;

// Runtime: 59 ms, faster than 75.80% of Java online submissions for Length of Longest Fibonacci Subsequence.
// Memory Usage: 38.7 MB, less than 96.20% of Java online submissions for Length of Longest Fibonacci Subsequence.
class Q873_len_of_longest_fibonacci_subseq_DP
{
    public int lenLongestFibSubseq(int[] A)
    {
        int N = A.length;
        // record the idex of the num in the origina seq
        Map<Integer, Integer> idx = new HashMap<Integer, Integer>();
        for( int i = 0; i < N; i++ ) idx.put( A[ i ], i );
        
        // stores the current len of the node pair (i, j)
        int[][] dp = new int[ N ][ N ];
        int ans = 0;

        // 2 nodes (i, j) and (j, k) are connected iff A[i] + A[j] == A[k]
        // to find A[ i ]: A[ i ] = A[ k ] - A[ j ]
        for( int k = 0; k < N; k++ )
            for( int j = 0; j < N; j++ )
            {
                int i = idx.getOrDefault( A[ k ] - A[ j ], -1 );
                // make sure the order is currect: i -> j -> k
                if( i >= 0 && i < j )
                {
                    // "+1": add the current number into the seq
                    // default len should be 2, since there are 2 nums in the seq already
                    int len = (dp[ i ][ j ] > 2 ? dp[ i ][ j ] : 2) + 1;
                    dp[ j ][ k ] = len;
                    ans = Math.max( ans, len );
                }
            }
        return ans >= 3 ? ans : 0;
    }
}