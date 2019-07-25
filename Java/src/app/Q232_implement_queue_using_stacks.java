package app;

import java.util.*;

class Q232_implement_queue_using_stacks
{
    Stack<Integer> s1;
    Stack<Integer> s2;
    int peek;

    /** Initialize your data structure here. */
    public Q232_implement_queue_using_stacks()
    {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x)
    {
        if( s1.isEmpty() ) peek = x;
        
        // inorder to keep s1 in the correct order
        while( !s1.isEmpty() ) s2.push( s1.pop() );
        s2.push( x );
        while( !s2.isEmpty() ) s1.push( s2.pop() );
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop()
    {
        int pop = s1.pop();
        if( !s1.empty() ) peek = s1.peek();
        return pop;
    }
    
    /** Get the front element. */
    public int peek()
    {
        return peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty()
    {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */