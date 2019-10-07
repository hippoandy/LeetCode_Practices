package app;

class Q26_rm_fup_from_arr
{
    // new solution
    public int removeDuplicates(int[] nums)
    {
        if( nums == null || nums.length == 0 ) return 0;
        
        int curr = nums[ 0 ];
        int i = 1;
        for( int j = 1; j < nums.length; j++ )
        {
            if( nums[ j ] == curr ) continue;
            else
            {
                // record the current value
                curr = nums[ j ];
                swap( nums, j, i );
                i++;
            }
        }
        return i;
    }
    
    private void swap( int[] arr, int a, int b )
    {
        int tmp = arr[ a ];
        arr[ a ] = arr[ b ];
        arr[ b ] = tmp;
    }

    // public int removeDuplicates(int[] nums) {
    //     int i = 0;
    //     for( int j = 0; j < nums.length; j++ )
    //     {
    //         if( nums[ i ] != nums[ j ] )
    //         {
    //             i++;
    //             nums[ i ] = nums[ j ]; // overwrite dup. value by unique value
    //         }
    //     }
    //     return i + 1;
    // }
}