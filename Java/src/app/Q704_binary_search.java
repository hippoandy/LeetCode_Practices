package app;

class Q704_binary_search
{
    public int search(int[] nums, int target)
    {
        if( nums == null ) return -1;
        if( nums.length == 0 ) return -1;

        int i = 0, j = nums.length-1;
        while( i <= j )
        {
            int mid = i + (j - i) / 2;
            if( nums[ mid ] == target ) return mid;
            else if( nums[ mid ] < target )
                i = mid + 1;
            else
                j = mid - 1;
        }
        return -1;
    }
}