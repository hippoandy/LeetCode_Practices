// ref. https://howtodoinjava.com/java/collections/arraylist/arraylist-remove-example/

package app;

import java.util.*;

public class Q716_max_stack
{
    class MaxStack
    {
        List<Integer> stack;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        /** initialize your data structure here. */
        public MaxStack() {
            this.stack = new ArrayList<Integer>();
        }
        
        public void push(int x)
        {
            this.stack.add( x );
            if( x >= this.max )
            {
                this.max = x;
                this.maxIdx = stack.size()-1;
            }
        }
        
        public int pop()
        {
            int ret = this.top();
            if( ret == this.max )
            {
                // perform removal first
                this.stack.remove( this.stack.size()-1 );
                // find the max element again
                this.findMax();
            }
            else
                this.stack.remove( this.stack.size()-1 );
            return ret;
        }
        
        public int top()
        {
            return this.stack.get( this.stack.size()-1 );
        }
        
        public int peekMax()
        {
            return this.max;
        }
        
        public int popMax()
        {
            int ret = this.max;
            // perform removal first
            this.stack.remove( this.maxIdx );
            // find the max element again
            this.findMax();
            return ret;
        }
        
        private void findMax()
        {
            this.max = Integer.MIN_VALUE;
            for( int i = 0; i < this.stack.size(); i++ )
                // since there could be multiple max value in the stack
                // find the one with the largest index
                if( stack.get( i ) >= max )
                {
                    this.max = stack.get( i );
                    this.maxIdx = i;
                }
        }
    }

    /**
     * Your MaxStack object will be instantiated and called as such:
     * MaxStack obj = new MaxStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.peekMax();
     * int param_5 = obj.popMax();
     */
}