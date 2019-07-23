package app;

class Q825_friends_of_appropriate_ages
{
    // Time Complexity: O(A^2 + N), where N is the number of people, and A is the num of ages.
    public int numFriendRequests(int[] ages)
    {
        if( ages == null ) return 0;
        if( ages.length == 0 ) return 0;
        
        // count how many people exist for each age
        // only 120 possible ages! 
        int[] count = new int[ 121 ];
        for( int age: ages ) count[ age ]++;
        
        int ans = 0;
        for( int A_age = 0; A_age <= 120; A_age++ )
        {
            int count_A = count[ A_age ];
            for( int B_age = 0; B_age <= 120; B_age++ )
            {
                if( B_age <= (A_age >> 1) + 7 )  continue;
                if( B_age > A_age )              continue;
                if( B_age > 100 && A_age < 100 ) continue;

                ans += count_A * count[ B_age ];
                // prevent sending request to itself
                // we should have countA * (countA - 1) pairs of people making friend requests instead
                if( A_age == B_age ) ans -= count_A;
            }
        }
        return ans;
    }
}

// class Solution
// {
//     // brute-force
//     // Time Limit Exceeded!!
//     public int numFriendRequests(int[] ages)
//     {
//         if( ages == null ) return 0;
//         if( ages.length == 0 ) return 0;

//         int count = 0;
//         Arrays.sort( ages );
//         for( int i = ages.length - 1; i >= 0; i-- )
//             for( int j = ages.length - 1; j >=0; j-- )
//             {
//                 if( j == i )                             continue;
//                 if( ages[ j ] <= ages[ i ] / 2 + 7 )     continue;
//                 if( ages[ j ] > ages[ i ])               continue;
//                 if( ages[ j ] > 100 && ages[ i ] < 100 ) continue;
                
//                 count++;
//             }
//         return count;
//     }
// }