package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
class Q852_peak_idx_in_a_mountain_arr_BINSEARCH
{
    // Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
    public int peakIndexInMountainArray(int[] A)
    {
        int i = 0;
        while( i + 1 < A.length && A[ i ] < A[ i + 1 ] ) i++;
        return i;
    }
}