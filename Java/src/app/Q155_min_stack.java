package app;

import java.util.*;

// Runtime: 45 ms, faster than 99.27% of Java online submissions for Min Stack.
// Memory Usage: 39.1 MB, less than 37.36% of Java online submissions for Min Stack.
public class Q155_min_stack
{
    class MinStack
    {
        List<Integer> stack;
        int min = Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack()
        {
            this.stack = new ArrayList<Integer>();
        }
        
        public void push( int x )
        {
            this.min = (x < this.min) ? x : this.min;
            this.stack.add( x );
        }
        
        public void pop()
        {
            if( this.top() == this.min )
            {
                // remove that element first to prevent incorrect result of getMin()
                this.stack.remove( stack.size()-1 );
                this.min = Integer.MAX_VALUE;
                for( int n: stack )
                    this.min = (n < this.min) ? n : this.min;
            }
            else
                this.stack.remove( stack.size()-1 );
        }
        
        public int top()
        {
            return this.stack.get( this.stack.size()-1 );
        }
        
        public int getMin()
        {
            return this.min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}