package app;

// Time complexity: O(n), where n is num. of all the element in A
class Q832_flipping_an_image
{
    public int[][] flipAndInvertImage(int[][] A)
    {
        for( int i = 0; i < A.length; i++ )
        {
            int left = 0, right = A[ i ].length - 1;
            while( left <= right )
            {
                // swap and invert
                int tmp = A[ i ][ left ] ^ 1;
                A[ i ][ left ] = (A[ i ][ right ] ^ 1);
                A[ i ][ right ] = (tmp);

                left++;
                right--;
            }
        }
        return A;
    }
}