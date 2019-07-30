// ref. https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java

package app;

// Runtime: 51 ms, faster than 29.40% of Java online submissions for Wiggle Sort II.
// Memory Usage: 40.2 MB, less than 96.34% of Java online submissions for Wiggle Sort II.
class Q324_wiggle_sort_2
{
    /* idea:
        13   6   5   5   4   2, median = 5

        Index :       0   1   2   3   4   5
        Small half:   M       S       S    
        Large half:       L       L       M
        
        M - Median, S-Small, L-Large.

        In this example, we want to put {13, 6, 5} in index 1,3,5
        and {5,4,2} in index {0,2,4}
    */
    public void wiggleSort(int[] nums)
    {
        // find the "median" of the array
        // which is "(nums.length + 1/2)-th largest element" in the arr
        int n = nums.length;
        int median = findKthLargest( nums, (n+1)/2 );
        
        // quick sort 3-way partition
        int l = 0, i = 0, r = n-1;
        while( i <= r )
        {
            /* i: 0 -> mapped: 1
               i: 1 -> mapped: 3
               i: 2 -> mapped: 5
               i: 3 -> mapped: 0
               i: 4 -> mapped: 2
               i: 5 -> mapped: 4
            */
            int cand = nums[ mappedIndex( i, n ) ];
            if( cand > median )
            {
                swap( nums, mappedIndex( l, n ), mappedIndex( i, n ) );
                l++;
                i++;
            }
            else if( cand < median )
            {
                swap( nums, mappedIndex( i, n ), mappedIndex( r, n ) );
                r--;
            }
            else i++;
        }
    }
    
    private int mappedIndex( int idx, int n )
    {
        // (1 + 2*idx) mapped to odd idx
        return (1 + 2*idx) % (n|1);
        // What (n|1) does it that it gets the next odd number to n if it was even
        // if n = 6, 110 | 1 = 111 = 7
        // if n = 7, 111 | 1 = 111 = 7
    }

    private void swap( int[] nums, int l, int r )
    {
        int tmp = nums[ l ];
        nums[ l ] = nums[ r ];
        nums[ r ] = tmp;
    }
    
    /*** solution from Q215 ***/
    public int findKthLargest(int[] a, int k)
    {
        int n = a.length;
        // n-k+1 since we are finding kth "largest"
        int p = quickSelect( a, 0, n - 1, n-k+1 );
        return a[ p ];
    }
    // return the index of the kth smallest number
    private int quickSelect( int[] a, int lo, int hi, int k )
    {
        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int i = lo, j = hi, pivot = a[ hi ];
        while( i < j )
        {
            // don't change the location of the pivot (1st iteration, pivot is at j)
            // if( a[ i++ ] > pivot ) swap( a, --i, --j );
            if( a[ i ] > pivot )
            {
                j--;
                swap( a, i, j );
            }
            else i++;
        }
        swap( a, i, hi );

        // count the nums that are <= pivot from lo
        int m = i - lo + 1;

        // pivot is the one!
        if( m == k )     return i;
        // pivot is too big, so it must be on the left
        else if( m > k ) return quickSelect( a,  lo, i-1, k );
        // pivot is too small, so it must be on the right
        else             return quickSelect( a, i+1,  hi, k-m );
    }
    
//     // wrong answer
//     public void wiggleSort(int[] nums)
//     {
//         if( nums == null ) return;
//         if( nums.length == 0 ) return;

//         for( int i = 0; i < nums.length; i++ )
//         {
//             int r = nums.length - 1;
//             if( i % 2 == 0 )
//             {   // n( i-1 ) > n( i ) < n( i+1 )
//                 if( i-1 >= 0 )
//                     if( nums[ i-1 ] <= nums[ i ] )
//                         do
//                         {
//                             swap( nums, i, r );
//                             r--;
//                         } while( nums[ i-1 ] < nums[ i ] );
//                 r = nums.length - 1;
//                 if( i+1 < nums.length )
//                     if( nums[ i ] >= nums[ i+1 ] )
//                         do
//                         {
//                             swap( nums, i, r );
//                             r--;
//                         } while( nums[ i ] > nums[ i+1 ] );
//             }
//             else
//             {   // n( i-1 ) < n( i ) > n( i+1 )
//                 if( i-1 >= 0 )
//                     if( nums[ i-1 ] >= nums[ i ] )
//                         do
//                         {
//                             swap( nums, i, r );
//                             r--;
//                         } while( nums[ i-1 ] > nums[ i ] );
//                 r = nums.length - 1;
//                 if( i+1 < nums.length )
//                     if( nums[ i ] <= nums[ i+1 ] )
//                         do
//                         {
//                             swap( nums, i, r );
//                             r--;
//                         } while( nums[ i ] < nums[ i+1 ] );
//             }
//             i++;
//         }
//     }
}