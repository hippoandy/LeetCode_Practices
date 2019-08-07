package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
// Memory Usage: 36 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
class Q88_merge_sorted_arr
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        // starting from the tail of the array
        int p1 = m-1;
        int p2 = n-1;
        // the real tail of nums1 arr
        // assume that nums1 has enough space
        int p = m + n - 1;
        
        while( p1 >= 0 && p2 >= 0 )
        {
            if( nums1[ p1 ] > nums2[ p2 ] )
            {
                nums1[ p ] = nums1[ p1 ];
                p1--;
            }
            else
            {
                nums1[ p ] = nums2[ p2 ];
                p2--;
            }
            p--;
        }
        // add missing elements from nums2
        // src, src_idx, dest, dest_idx, len
        System.arraycopy( nums2, 0, nums1, 0, p2+1 );
    }
}