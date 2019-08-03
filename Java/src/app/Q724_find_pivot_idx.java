package app;

class Q724_find_pivot_idx
{
    public int pivotIndex(int[] nums)
    {
        int sum = 0, leftSum = 0;
        for( int n: nums ) sum += n;
        
        for( int i = 0; i < nums.length; i++ )
        {
            // the middle element could not be part of any array
            // so - nums[ i ]
            if( leftSum == (sum - leftSum - nums[ i ]) ) return i;
            leftSum += nums[ i ];
        }
        return -1;
    }
}