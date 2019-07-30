// ref. https://www.wikiwand.com/en/Reverse_Polish_notation

package app;

import java.util.*;

class Q150_evaluate_reverse_polish_notation
{
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> stack = new Stack<Integer>();
        
        for( String token: tokens )
        {
            if( token.equals( "+" ) )
            {
                int b = stack.pop();
                int a = stack.pop();
                stack.push( a+b  );
            }
            else if(  token.equals( "-" ) )
            {
                int b = stack.pop();
                int a = stack.pop();
                stack.push( a-b  );
            }
            else if(  token.equals( "*" ) )
            {
                int b = stack.pop();
                int a = stack.pop();
                stack.push( a*b  );
            }
            else if(  token.equals( "/" ) )
            {
                int b = stack.pop();
                int a = stack.pop();
                stack.push( a/b  );
            }
            else
                stack.push( Integer.parseInt( token ) );
        }
        return stack.pop();
    }
}