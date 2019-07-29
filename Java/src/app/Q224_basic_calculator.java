// ref. [SOLUTION] https://leetcode.com/problems/basic-calculator/discuss/62362/JAVA-Easy-Version-To-Understand!!!!!
// ref. [Java Char is numeric] https://stackoverflow.com/questions/4047808/what-is-the-best-way-to-tell-if-a-character-is-a-letter-or-number-in-java-withou
// ref. [Java Char to int] https://www.javatpoint.com/java-char-to-int

package app;

import java.util.*;

// Runtime: 13 ms, faster than 49.67% of Java online submissions for Basic Calculator.
// Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Basic Calculator.
class Q224_basic_calculator
{
    public int calculate(String s)
    {
//         Map<String, Integer> priority = new HashMap<String, Integer>();
//         priority.put( '*', 3 );
//         priority.put( '/', 3 );
//         priority.put( '+', 2 );
//         priority.put( '-', 2 );
//         priority.put( '(', 1 );

        Stack<Integer> stack = new Stack<Integer>();
        
        int tmp = 0;
        int operand = 0;
        int sign = 1;       // 1 means positive, -1 means negative
        for( int i = 0; i < s.length(); i++ )
        {
            char c = s.charAt( i );
            if( Character.isDigit( c ) )
                operand = operand * 10 + (int) (c - '0');
            else if( c == '+' )
            {
                tmp += sign * operand;
                // save the recently encountered '+'
                sign = 1;
                operand = 0;
            }
            else if( c == '-' )
            {
                tmp += sign * operand;
                sign = -1;
                operand = 0;
            }
            else if( c == '(' )
            {
                stack.push( tmp );
                stack.push( sign );
                
                sign = 1;
                tmp = 0;
            }
            else if( c == ')' )
            {
                tmp += sign * operand;
                
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                tmp *= stack.pop();
                
                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                tmp += stack.pop();
                
                operand = 0;
            }
        }
        return tmp + (sign * operand);
    }
}