// ref. https://leetcode.com/problems/find-peak-element/discuss/50239/Java-solution-and-explanation-using-invariants

package app;

public class Q162_find_peak_element
{
    public int findPeakElement(int[] nums)
    {
        return search( nums, 0, nums.length-1 );
    }

    public int search(int[] nums, int l, int r)
    {
        if (l == r) return l;
        int mid = (l + r) / 2;
        if( nums[ mid ] > nums[ mid+1 ] )
            return search( nums, l, mid );
        // mid is not possible to be a peak, just check the right
        return search( nums, mid+1, r );
    }
}