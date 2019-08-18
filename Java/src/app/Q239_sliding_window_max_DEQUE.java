// ref. https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation

package app;

import java.util.*;

// deque: double-ended queue
class Q239_sliding_window_max_DEQUE
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;
        if( n * k == 0 ) return new int[ 0 ];
        if( k == 1 ) return nums;
        
        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        int[] output = new int[ n-k+1 ];
        int idx = 0;
        for( int i = 0; i < n; i++ )
        {
            // if the first element is out of the window
            if( !dq.isEmpty() && dq.peek() < i - k + 1 ) dq.remove();
            // make sure the largest element is at the front
            while( !dq.isEmpty() && nums[ dq.peekLast() ] <= nums[ i ] )
                dq.removeLast();
            // offer the current index to deque
            dq.offer( i );
            if( i >= k-1 ) // "-1" since 0-index
                output[ idx++ ] = nums[ dq.peek() ];
        }
        return output;
    }
}