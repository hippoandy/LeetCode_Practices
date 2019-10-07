package app;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
// Memory Usage: 37.9 MB, less than 95.10% of Java online submissions for Move Zeroes.
class Q283_mv_zeroes
{
    public void moveZeroes(int[] nums)
    {
        if( nums == null | nums.length == 0 ) return;

        int i = 0;
        for( int j = 0; j < nums.length; j++ )
            if( nums[ j ] != 0 )
            {
                swap( nums, j, i );
                // prevent the array with length 1
                if( i != j ) nums[ j ] = 0;
                i++;
            }
    }
    
    private void swap( int[] arr, int a, int b )
    {
        int tmp = arr[ a ];
        arr[ a ] = arr[ b ];
        arr[ b ] = tmp;
    }
}