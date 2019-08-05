// ref. https://leetcode.com/problems/remove-k-digits/discuss/88678/Two-algorithms-with-detailed-explaination
// ref. https://leetcode.com/problems/remove-k-digits/discuss/88708/Straightforward-Java-Solution-Using-Stack

package app;

import java.util.*;

class Q402_rm_k_digits
{
    // // intuitive
    // // find the peak from left to right and delete the peak!
    // // Runtime: 31 ms, faster than 12.80% of Java online submissions for Remove K Digits.
    // // Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove K Digits.
    // // Time complexity: O(k*n)
    // public String removeKdigits(String num, int k)
    // {
    //     if( num == null ) return num;
    //     if( k < 0 ) return num;
    //     if( num.length() == 0 ) return num;
    //     // corner case
    //     if( num.length() == k ) return "0";
        
    //     StringBuilder sb = new StringBuilder( num );
    //     // scan from left to right, find the peak and remove it
    //     while( k > 0 )
    //     {
    //         int i = 0;
    //         // every time the size of the string should be considered!
    //         // since we are deleting the char in real-time
    //         int n = sb.length();
    //         // finding the peak
    //         while( i < n-1 && sb.charAt( i ) <= sb.charAt( i+1 ) ) i++;
    //         // remove the peak
    //         sb.deleteCharAt( i );
    //         k--;
    //     }
        
    //     // dealing with the leading 0
    //     int i = 0;
    //     while( i < sb.length()-1 && sb.charAt( i ) == '0' ) i++;
    //     // earse the string from i to j
    //     sb.delete( 0, i );
        
    //     return sb.toString();
    // }

    // Stack
    // Runtime: 15 ms, faster than 28.95% of Java online submissions for Remove K Digits.
    // Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove K Digits.
    // Time complexity: O(n)
    public String removeKdigits(String num, int k)
    {
        if( num == null ) return num;
        if( k < 0 ) return num;
        if( num.length() == 0 ) return num;
        // corner case
        if( num.length() == k ) return "0";

        // scan from left to right, find the peak and remove it
        Stack<Character> stack = new Stack<Character>();
        for( int i = 0; i < num.length(); i++ )
        {
            while( k > 0 && !stack.isEmpty() && stack.peek() > num.charAt( i )  )
            {
                stack.pop();
                k--;
            }
            stack.push( num.charAt( i ) );
        }
        while( k > 0 )
        {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty() ) sb.insert( 0, stack.pop() );
        // dealing with the leading 0
        while( sb.length() > 1 && sb.charAt( 0 ) == '0' )
            sb.deleteCharAt( 0 );
        
        return (sb.length() > 0) ? sb.toString() : "0";
    }
}