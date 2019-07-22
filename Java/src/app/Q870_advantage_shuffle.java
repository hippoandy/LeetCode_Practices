package app;

import java.util.*;

class Q870_advantage_shuffle
{
    public int[] advantageCount(int[] A, int[] B)
    {
        int[] A_sorted = A.clone();
        int[] B_sorted = B.clone();
        Arrays.sort( A_sorted );
        Arrays.sort( B_sorted );
        
        // stores list of values that beats b
        Map<Integer, Queue<Integer>> assigned = new HashMap<Integer, Queue<Integer>>();
        for( int b: B ) assigned.put( b, new LinkedList<Integer>() );
        
        // stores list of values that not assigned to any b
        Queue<Integer> remainings = new LinkedList<Integer>();
        
        int j = 0;
        for( int a: A_sorted )
        {
            // record the values that beats b
            if( a > B_sorted[ j ] ) assigned.get( B_sorted[ j++ ] ).add( a );
            else
                // not able to beat anyone
                remainings.add( a );
        }
        
        int[] ans = new int[ A.length ];
        for( int i = 0; i < B.length; i++ )
        {
            if( assigned.get( B[ i ] ).size() > 0 )
                ans[ i ] = assigned.get( B[ i ] ).remove();
            else
                ans[ i ] = remainings.remove();
        }
        return ans;
    }
}

// failed!!
// class Solution {
//     public int[] advantageCount(int[] A, int[] B)
//     {
//         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
//         int[] ans = new int[ A.length ];
//         for( int i = 0; i < ans.length; i++ ) ans[ i ] = Integer.MIN_VALUE;
        
//         for( int i = 0; i < B.length; i++ ) map.put( i, B[ i ] );
//         Arrays.sort( A );
//         Arrays.sort( B );

//         for( int i = 0; i < A.length; i++ )
//         {
//             if( A[ i ] > B[ i ] )
//             {
//                 int k = 0;
//                 for( Map.Entry<Integer, Integer> entry : map.entrySet() )
//                     if( entry.getValue() == B[ i ] )
//                     {
//                         ans[ entry.getKey() ] = A[ i ];
//                         A[ i ] = Integer.MIN_VALUE;
//                         k = entry.getKey();
//                         break;
//                     }
//                 map.remove( k );
//             }
//         }
        
//         for( int k: map.keySet() )
//         {
//             for( int i = 0; i < A.length; i++ )
//             {
//                 if( A[ i ] != Integer.MIN_VALUE )
//                 {
//                     ans[ k ] = A[ i ];
//                     A[ i ] = Integer.MIN_VALUE;
//                 }
//             }
//         }
//         return ans;
//     }
// }