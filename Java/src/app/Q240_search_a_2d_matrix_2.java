package app;

class Q240_search_a_2d_matrix_2
{
    // Runtime: 5 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
    // Memory Usage: 42.4 MB, less than 100.00% of Java online submissions for Search a 2D Matrix II.
    // Time complexity: O(n + m)
    // Space complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int tar)
    {
        if( matrix == null ) return false;
        int m = matrix.length;
        if( m == 0 ) return false;
        int n = matrix[ 0 ].length;
        if( n == 0 ) return false;

        int r = m-1, c = 0;
        // search space reduction
        while( r >= 0 && c < n )
        {
            if( matrix[ r ][ c ] > tar )
                r--;
            else if( matrix[ r ][ c ] < tar )
                c++;
            else
                return true;
        }
        return false;
    }

    // // Runtime: 6 ms, faster than 30.14% of Java online submissions for Search a 2D Matrix II.
    // // Memory Usage: 44.6 MB, less than 97.21% of Java online submissions for Search a 2D Matrix II.
    // Time complexity: O(log(n!))
    // Space complexity: O(1)
    // int m, n;
    // public boolean searchMatrix(int[][] matrix, int tar)
    // {
    //     if( matrix == null ) return false;
    //     m = matrix.length;
    //     if( m == 0 ) return false;
    //     n = matrix[ 0 ].length;
    //     if( n == 0 ) return false;
        
    //     int shorter = (m >= n) ? n : m;
    //     for( int i = 0; i < shorter; i++ )
    //     {
    //         boolean v = binarySearch( matrix, tar, i,  true );
    //         boolean h = binarySearch( matrix, tar, i, false );
    //         if( v || h ) return true;
    //     }
    //     return false;
    // }
    // public boolean binarySearch( int[][] matrix, int tar, int start, boolean vertical )
    // {
    //     int l = start;
    //     int h = (vertical) ? m-1 : n-1;
        
    //     while( l <= h )
    //     {
    //         int mid = l + (h - l) / 2;
    //         if( vertical )  // search row
    //         {
    //             if( matrix[ mid ][ start ] < tar )
    //                 l = mid + 1;
    //             else if( matrix[ mid ][ start ] > tar )
    //                 h = mid - 1;
    //             else
    //                 return true;
    //         }
    //         else            // search column
    //         {
    //             if( matrix[ start ][ mid ] < tar )
    //                 l = mid + 1;
    //             else if( matrix[ start ][ mid ] > tar )
    //                 h = mid -1;
    //             else
    //                 return true;
    //         }
    //     }
    //     return false;
    // }
}