// ref. https://www.wikiwand.com/en/Dutch_national_flag_problem
// ref. https://leetcode.com/problems/sort-colors/discuss/148221/Java-2-pass-counting-sort-and-1-pass-quick-partition-(with-video-tutorial-links)

package app;

class Q75_sort_colors_DNF
{
    // quick sort 3-way partition
    public void sortColors(int[] nums)
    {
        // i = idex of element unvisited
        int l = 0, m = 0, r = nums.length - 1;
        while( m <= r )
        {
            if( nums[ m ] == 2 )
            {
                // swap with last digit
                swap( nums, m, r );
                // the last digit is now sorted
                r--;
            }
            else if( nums[ m ] == 0 )
            {
                // swap with fist digit
                swap( nums, l, m );
                l++; m++;
            }
            // keep moving
            else    m++;
        }
    }
    
    public void swap( int[] nums, int a, int b )
    {
        int tmp = nums[ a ];
        nums[ a ] = nums[ b ];
        nums[ b ] = tmp;
    }
}