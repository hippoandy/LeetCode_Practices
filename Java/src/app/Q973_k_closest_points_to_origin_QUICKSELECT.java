// ref. https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.

package app;

import java.util.*;

// Runtime: 4 ms, faster than 99.43% of Java online submissions for K Closest Points to Origin.
// Memory Usage: 58.2 MB, less than 81.18% of Java online submissions for K Closest Points to Origin.
class Q973_k_closest_points_to_origin_QUICKSELECT
{    
    public int[][] kClosest(int[][] points, int K)
    {
        int len =  points.length, l = 0, r = len - 1;
        while( l <= r )
        {
            int mid = helper( points, l, r );
            if( mid == K ) break;
            if( mid < K )
                l = mid + 1;
            else
                r = mid - 1;
        }
        return Arrays.copyOfRange( points, 0, K );
    }

    private int helper( int[][] A, int l, int r )
    {
        int[] pivot = A[ l ];
        while( l < r )
        {
            while( l < r && compare(A[r], pivot) >= 0 ) r--;
            A[l] = A[r];
            while( l < r && compare(A[l], pivot) <= 0 ) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2)
    {
        return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
    }

//      Official Solution: Time Limit Exceeded!!
//     int[][] points;

//     Random rand = new Random();
    
//     public int[][] kClosest(int[][] points, int K)
//     {
//         this.points = points;
//         quickSelect( 0, points.length - 1, K );
//         return Arrays.copyOfRange( this.points, 0, K );
//     }

//     private void quickSelect( int i, int j, int K )
//     {
//         if( i >= j ) return;
//         // random selected pivotIdx
//         int pivotIdx = rand.nextInt( j - i ) + i;
//         swap( i, pivotIdx );
        
//         int mid = partition( i, j );
//         int leftLen = mid - i + 1;
//         if( K < leftLen )
//             quickSelect( i, mid-1, K );
//         else if( K > leftLen )
//             quickSelect( mid+1, j, K-leftLen );
//         else
//             return;
//     }

//     private int partition( int i, int j )
//     {
//         int old_i = i;
//         int pivot = dist( this.points[ i ] );
//         i++;
        
//         while( true )
//         {
//             while( i < j  && dist( this.points[ i ] ) < pivot ) i++;
//             while( j >= i && dist( this.points[ j ] ) > pivot ) j--;
//             if( i >= j ) break;
//             swap( i, j );
//         }
//         swap( old_i, j );
//         return j;
//     }

//     private int dist( int[] p )
//     {
//         return p[ 0 ] * p[ 0 ] + p[ 1 ] * p[ 1 ];
//     }

//     private void swap( int i, int j )
//     {
//         int p0 = this.points[ i ][ 0 ], p1 = this.points[ i ][ 1 ];
//         this.points[ i ][ 0 ] = this.points[ j ][ 0 ];
//         this.points[ i ][ 1 ] = this.points[ j ][ 1 ];
//         this.points[ j ][ 0 ] = p0;
//         this.points[ j ][ 1 ] = p1;
//     }
}