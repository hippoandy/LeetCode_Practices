// ref. https://leetcode.com/problems/occurrences-after-bigram/discuss/339935/Easy-Java-Solution-Using-Stacks-100-Memory

package app;

import java.util.*;

class Q1078_occurrences_after_bigram
{
    public String[] findOcurrences(String text, String first, String second)
    {
        if( text.equals( "" ) ) return null;
        
        List<String> res = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();

        String[] words = text.split( " " );
        
        for( String w: words )
        {
            if( stack.size() >= 2 )
            {
                if( stack.peek().equals( second ) )
                {
                    stack.pop();
                    if( stack.peek().equals( first ) )
                        res.add( w );
                    // push the second back to stack
                    stack.push( second );
                    // push the current word to stack
                    stack.push( w );
                }
                else stack.push( w );
            }
            else stack.push( w );
        }
        String[] ans = new String[ res.size() ];
        int idx = 0;
        for( String s: res ) ans[ idx++ ] = s;
        return ans;
    }
}

// failed:
/* case: "we will we will rock you"
         first: "we"
         second: "will"

   return: ["we_will"]
 */
// class Solution {
//     public String[] findOcurrences(String text, String first, String second)
//     {
//         if( text.equals( "" ) ) return null;

//         text = text.replaceAll( first + " " + second, first + "_" + second );
//         String[] parts = text.split( " " );
        
//         List<String> tmp = new ArrayList<String>();

//         for( int i = 0; i < parts.length; i++ )
//             if( parts[ i ].equals( first + "_" + second ) )
//             {
//                 if( i + 1 < parts.length )
//                     tmp.add( parts[ ++i ] );
//             }
        
//         String[] ans = new String[ tmp.size() ];
//         int idx = 0;
//         for( String s: tmp ) ans[ idx++ ] = s;
//         return ans;
//     }
// }