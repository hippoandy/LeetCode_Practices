package app;

import java.util.*;

// Runtime: 5 ms, faster than 17.72% of Java online submissions for Trapping Rain Water.
// Memory Usage: 37.9 MB, less than 92.08% of Java online submissions for Trapping Rain Water.
class Solution
{
    // using stack
    public int trap(int[] height)
    {
        if( height == null ) return 0;
        int n = height.length;
        if( n == 0 ) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        
        int ans = 0;
        for( int i = 0; i < n; i++ )
        {
            while( !stack.isEmpty() && height[ i ] > height[ stack.peek() ] )
            {
                int pre = stack.pop();
                if( stack.isEmpty() ) break;
                // find the previous bounded height
                int dist = (i - stack.peek() - 1);
                int bounded = Math.min( height[ i ], height[ stack.peek() ] ) - height[ pre ];
                ans += dist * bounded;
            }
            stack.push( i );
        }
        return ans;
    }
}