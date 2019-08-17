package app;

import java.util.*;

class Q179_largest_num
{
    // version 2
    public String largestNumber(int[] nums)
    {
        String[] strs = new String[ nums.length ];
        int idx = 0;
        for( int i: nums ) strs[ idx++ ] = Integer.toString( i );
        
        // sort the array
        Arrays.sort( strs, new Comparator<String>()
        {   @Override
            public int compare( String a, String b )
            {   // larger combination first
                String ab = a + b, ba = b + a;
                return ba.compareTo( ab );
            }
        });
        // consider case [ "0", "0" ]
        if( strs[ 0 ].equals( "0" ) ) return "0";
        return String.join( "", strs );
    }

    // version 1
    // public String largestNumber(int[] nums)
    // {
    //     String[] strs = new String[ nums.length ];
    //     for( int i = 0; i < nums.length; i++ )
    //         strs[ i ] = Integer.toString( nums[ i ] );
        
    //     // sort the array with customized comparator
    //     Arrays.sort( strs,
    //         new largerFirstDigitString()
    //     );
        
    //     // for case [ "0", "0" ]
    //     if( strs[ 0 ].equals( "0" ) ) return "0";
        
    //     String ans = "";
    //     for( String s: strs )
    //         ans += s;
    //     return ans;
    // }
    // private class largerFirstDigitString implements Comparator<String>
    // {
    //     @Override
    //     public int compare( String a, String b )
    //     {
    //         String ab = a + b;
    //         String ba = b + a;
    //         return ba.compareTo( ab );
    //     }
    // }

//     // Wrong Answer!!
//     // the number couldn't be changed......
//     public String largestNumber(int[] nums)
//     {
//         if( nums == null ) return "";
//         if( nums.length == 0 ) return "";

//         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
//         // count the digit
//         for( int i = 0; i < nums.length; i++ )
//         {
//             int n = nums[ i ];
//             while( n != 0 )
//             {
//                 int d = n % 10;
//                 map.put( d, map.getOrDefault( d, 0 ) + 1 );
//                 n /= 10;
//             }
//         }
        
//         String ans = "";
//         for( int i = 9; i >= 0; i-- )
//         {
//             if( map.containsKey( i ) )
//             {
//                 for( int j = map.get( i ); j > 0; j-- )
//                     ans += Integer.toString( i );
//             }
//         }
//         return ans;
//     }
}