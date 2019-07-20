package app;

class Q941_valid_mountain_arr
{
    // public boolean validMountainArray(int[] A)
    // {
    //     if( A == null ) return false;
    //     if( A.length == 0 ) return false;
        
    //     int pre = A[ 0 ], peak = 0;
    //     boolean increasing = false, decreasing = false;
    //     for( int i = 1; i < A.length; i++ )
    //     {
    //         if( A[ i ] == pre ) return false;
    //         if( A[ i ] < pre && i == 1 ) return false;
    //         if( i >= 1 && A[ i ] > pre )
    //         {
    //             if( decreasing ) return false;
    //             increasing = true;
    //         }
    //         if( i > 1 && A[ i ] < pre )
    //         {
    //             if( !decreasing )
    //             {
    //                 peak = A[ i ];
    //                 decreasing = true;
    //             }
    //             if( A[ i ] > peak ) return false;
    //         }
    //         pre = A[ i ];
    //     }
    //     return increasing && decreasing;
    // }

    // logic improved
    public boolean validMountainArray(int[] A)
    {
        int n = A.length;
        int i = 0;
        
        // walk up
        while( i+1 < n && A[ i ] < A[ i+1 ] ) i++;
        
        // peak can't be first or last
        if( i == 0 || i == n-1 ) return false;
        
        // walk down
        while( i+1 < n && A[ i ] > A[ i+1 ] ) i++;
        
        // if the walker couldn't get to the last, there exist some error
        return i == n-1;
    }
}