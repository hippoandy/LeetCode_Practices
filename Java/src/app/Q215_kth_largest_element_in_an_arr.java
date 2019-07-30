package app;

import java.util.*;

class Q215_kth_largest_element_in_an_arr
{
    public int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(
          (a, b) -> a - b
        );
        
        for( int n: nums )
        {
            q.offer( n );
            if( q.size() > k ) q.remove();
        }
        return q.remove();
    }
}