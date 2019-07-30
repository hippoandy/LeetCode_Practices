// ref. [SOLUTION] https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60312/AC-Clean-QuickSelect-Java-solution-avg.-O(n)-time
// ref. [SOLUTION] https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
// ref. [WIKIPEDIA - QUICKSELECT] https://www.wikiwand.com/en/Quickselect
// ref. [++i OR i++] https://stackoverflow.com/questions/24853/c-what-is-the-difference-between-i-and-i

package app;

// Runtime: 29 ms, faster than 31.27% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 38 MB, less than 62.17% of Java online submissions for Kth Largest Element in an Array.
class Q215_kth_largest_element_in_an_arr_QUICKSELECT
{  
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

    private void swap( int[] a, int i, int j )
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}