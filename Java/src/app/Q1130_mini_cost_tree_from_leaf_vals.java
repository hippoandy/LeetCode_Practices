package app;

import java.util.*;

class Q1130_mini_cost_tree_from_leaf_vals
{
    public int mctFromLeafValues(int[] arr)
    {
        Stack<Integer> stack = new Stack<Integer>();
        
        int res = 0;
        for( int a: arr )
        {
            while( !stack.isEmpty() && stack.peek() <= a )
            {
                int mid = stack.pop();
                res += (stack.isEmpty()) ? mid * a : mid * Math.min( stack.peek(), a );
            }
            stack.push( a );
        }
        while( stack.size() > 1 ) res += stack.pop() * stack.peek();
        
        return res;
    }
}