package app;

class Q31_next_permutation
{
    public void nextPermutation(int[] nums)
    {
        if( nums == null ) return;
        if( nums.length == 0 ) return;

        int i = nums.length - 2;
        // find the first pair that nums[ i ] < nums[ i+1 ]
        while( i >= 0 && nums[ i+1 ] <= nums[ i ] ) i--;
        if( i >= 0 )
        {
            int j = nums.length-1;
            // find the first element that nums[ j ] > nums[ i ]
            while( j >= 0 && nums[ j ] <= nums[ i ] ) j--;
            swap( nums, i, j );
        }
        // reverse the right part [ptr ... tail]
        reverse( nums, i+1  );
        return;
    }
    
    private void reverse( int[] nums, int l )
    {
        int h = nums.length - 1;
        while( l < h )
        {
            swap( nums, l, h );
            l++;
            h--;
        }
    }
    
    private void swap( int[] nums, int a, int b )
    {
        int tmp = nums[ a ];
        nums[ a ] = nums[ b ];
        nums[ b ] = tmp;
    }
}