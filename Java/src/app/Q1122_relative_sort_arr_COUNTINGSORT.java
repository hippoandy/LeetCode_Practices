// ref. https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort

// Follow-up: What if this constraint 0 <= arr1[i], arr2[i] <= 1000 doesn't exist?
//       Ans: Use TreeMap

package app;

// counting sort
// Time:  O(1) since 1001 cells
// Space: O(1) since 1001 cells
class Q1122_relative_sort_arr_COUNTINGSORT
{
    public int[] relativeSortArray(int[] arr1, int[] arr2)
    {
        // since 0 <= arr1[i], arr2[i] <= 1000
        int[] cnt = new int[ 1000 + 1 ]; // since 0-index
        for( int n : arr1 ) cnt[ n ]++;
        
        int i = 0;
        // get the count for num in arr2 and populate into arr1
        for( int n : arr2 )
            while( cnt[ n ]-- > 0 ) arr1[ i++ ] = n;

        // for those number that is not originally in arr2 but arr1
        for( int n = 0; n < cnt.length; n++ )
            // if the value != 0, then that's the number not in arr2 but arr1
            while( cnt[ n ]-- > 0 ) arr1[ i++ ] = n;

        return arr1;
    }
}