package app;

import java.util.*;

// Runtime: 42 ms, faster than 86.70% of Java online submissions for Implement Stack using Queues.
// Memory Usage: 34.2 MB, less than 91.29% of Java online submissions for Implement Stack using Queues.
public class Q225_implement_stack_using_queues
{
    class MyStack
    {
        Queue<Integer> queue;
        Queue<Integer> tmp;
        int top;
        
        /** Initialize your data structure here. */
        public MyStack()
        {
            queue = new LinkedList<Integer>();
            tmp = new LinkedList<Integer>();
        }
        
        /** Push element x onto stack. */
        public void push(int x)
        {
            queue.offer( x );
            top = x;
        }
        
        /** Removes the element on top of the stack and returns that element. */
        public int pop()
        {
            while( queue.size() > 1 )
            {
                top = queue.remove();
                tmp.offer( top );
            }
            // pop the element
            int pop = queue.remove();
            
            queue = tmp;
            tmp = new LinkedList<Integer>();
            
            return pop;
        }
        
        /** Get the top element. */
        public int top()
        {
            return top;
        }
        
        /** Returns whether the stack is empty. */
        public boolean empty()
        {
            if( queue.size() != 0 ) return false;
            return true;
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}