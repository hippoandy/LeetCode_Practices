package app;

class Q905_sort_arr_by_parity
{
    public int[] sortArrayByParity(int[] A)
    {
        int left = 0, right = A.length - 1;
        while( left < right )
        {
            if( A[ left ] % 2 > A[ right ] % 2 )
            {
                int tmp = A[ left ];
                A[ left ] = A[ right ];
                A[ right ] = tmp;
            }
            
            if( A[ left ] % 2 == 0 )    left++;
            if( A[ right ] % 2 != 0 )   right--;
        }
        return A;
    }
}