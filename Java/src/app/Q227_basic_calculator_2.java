// ref. https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution

package app;

import java.util.*;

// Runtime: 21 ms, faster than 40.73% of Java online submissions for Basic Calculator II.
// Memory Usage: 38.5 MB, less than 84.87% of Java online submissions for Basic Calculator II.
class Q227_basic_calculator_2
{
    public int calculate(String s)
    {
        int len;
        if( s == null || (len = s.length() ) == 0 ) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for( int i = 0; i < len; i++ )
        {
            char c = s.charAt( i );
            // operand
            if( Character.isDigit( c ) )
                num = num * 10 + (int) c - '0';
            // operator
            if( (!Character.isDigit( c ) && ' ' != c) || i == len-1 )
            {
                if( sign == '-' )   stack.push( -num );
                if( sign == '+' )   stack.push( num );
                if( sign == '*' )   stack.push( stack.pop() * num );
                if( sign == '/' )   stack.push( stack.pop() / num );
                sign = c;
                num = 0;
            }
        }
        
        int ans = 0;
        while( !stack.isEmpty() ) ans += stack.pop();
        return ans;
    }

    // public int calculate(String s)
    // {
    //     int len;
    //     if( s==null || (len = s.length() ) == 0 ) return 0;

    //     Stack<Integer> stack = new Stack<Integer>();
    //     int num = 0;
    //     char sign = '+';
    //     for( int i = 0; i < len; i++ )
    //     {
    //         char c = s.charAt( i );
    //         if( Character.isDigit( c ) )
    //         {
    //             num = num * 10 + (int) c - '0';
    //         }
    //         if( (!Character.isDigit( c ) && ' ' != c) || i == len-1 )
    //         {
    //             if( sign == '-' )
    //                 stack.push( -num );
    //             if( sign == '+' )
    //                 stack.push( num );
    //             if( sign == '*' )
    //                 stack.push( stack.pop()*num );
    //             if( sign == '/' )
    //                 stack.push( stack.pop()/num );
    //             sign = c;
    //             num = 0;
    //         }
    //     }
        
    //     int ans = 0;
    //     while( !stack.isEmpty() )
    //         ans += stack.pop();
    //     return ans;
    // }
}