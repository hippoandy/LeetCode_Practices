package app;

import java.util.*;

class Q933_num_of_recent_calls
{
    Queue<Integer> queue;
    public Q933_num_of_recent_calls()
    {
        queue = new LinkedList<Integer>();
    }
    
    public int ping(int t)
    {
        queue.add( t );
        while( queue.peek() < t - 3000 ) queue.poll();
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */