package app;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Array Nesting
// Memory Usage: 47 MB, less than 31.58% of Java online submissions for Array Nesting.
class Q565_arr_nesting
{
    public int arrayNesting(int[] nums)
    {
        int max = 0;
        for( int i = 0; i < nums.length; i++ )
        {
            // N is an integer within the range [1, 20,000].
            // therefore, we could use Integer.MAX_VALUE or -1 as a marker
            if( nums[ i ] != -1 )
            {
                int start = nums[ i ], count = 0;
                while( nums[ start ] != -1 )
                {
                    int tmp = start;
                    start = nums[ start ];
                    count++;
                    // mark visited
                    nums[ tmp ] = -1;
                }
                max = (count > max) ? count : max;
            }
        }
        return max;
    }
    
//     // brute-force
//     int max = 0;
//     public int arrayNesting(int[] nums)
//     {
//         if( nums == null || nums.length == 0 ) return 0;

//         for( int i = 0; i < nums.length; i++ )
//             helper( nums, i, new HashSet<Integer>() );
//         return max;
//     }
//     private void helper( int[] nums, int idx, Set<Integer> set )
//     {
//         if( !set.add( nums[ idx ] ) )
//         {
//             max = (set.size() > max) ? set.size() : max;
//             return;
//         }
//         else
//             helper( nums, nums[ idx ], set );
//     }
}