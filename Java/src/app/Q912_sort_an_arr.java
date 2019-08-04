// ref. [QUICK SORT] https://www.geeksforgeeks.org/quick-sort/
// ref. [MERGE SORT (In-place)] https://www.geeksforgeeks.org/in-place-merge-sort/

package app;

class Q912_sort_an_arr
{
    public int[] sortArray(int[] nums)
    {
        if( nums == null ) return nums;
        if( nums.length == 0 ) return nums;
        
        // quickSort( nums, 0, nums.length-1 );
        mergeSort( nums, 0, nums.length-1 );
        return nums;
    }
    
    /* ******************** quick sort ******************** */
    // Runtime: 8 ms, faster than 37.64% of Java online submissions for Sort an Array.
    // Memory Usage: 40.8 MB, less than 100.00% of Java online submissions for Sort an Array.
    private void quickSort( int[] nums, int l, int h )
    {
        if( l < h )
        {
            int pi = partition( nums, l, h );
            quickSort( nums, l, pi-1 );
            quickSort( nums, pi+1, h );
        }
    }
    private int partition( int[] nums, int l, int h )
    {
        int pivot = nums[ h ];
        
        int i = (l - 1);
        for( int j = l; j < h; j++ )
        {
            if( nums[ j ] <= pivot )
            {
                i++;
                swap( nums, i, j );
            }
        }
        swap( nums, i+1, h );
        return i+1;
    }
    private void swap( int[] nums, int i, int j )
    {
        int t = nums[ i ];
        nums[ i ] = nums[ j ];
        nums[ j ] = t;
    }

    /* ******************** merge sort ******************** */
    // Runtime: 189 ms, faster than 11.64% of Java online submissions for Sort an Array.
    // Memory Usage: 41 MB, less than 100.00% of Java online submissions for Sort an Array.
    private void mergeSort( int[] nums, int l, int h )
    {
        if( l < h )
        {
            int mid = l + (h - l) / 2;
            mergeSort( nums, l, mid );
            mergeSort( nums, mid+1, h );
            
            merge( nums, l, mid, h );
        }
    }
    private void merge( int[] nums, int s, int m, int e )
    {
        //stores the starting position of both parts in temporary variables.
        int s2 = m+1;

        // If the direct merge is already sorted 
        if( nums[ m ] <= nums[ s2 ]) return;

        // Two pointers to maintain start 
        // of both arrays to merge 
        while( s <= m && s2 <= e )
        {
            // If element 1 is in right place 
            if( nums[ s ] <= nums[ s2 ]) s++;
            else
            {
                int value = nums[ s2 ];
                int index = s2;

                // Shift all the elements between element 1
                // element 2, right by 1.
                while( index != s )
                {
                    nums[ index ] = nums[ index - 1 ];
                    index--; 
                } 
                nums[ s ] = value;

                // Update all the pointers 
                s++; s2++; m++;
            } 
        } 
    }
}