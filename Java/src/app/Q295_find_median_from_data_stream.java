package app;

import java.util.*;

class Q295_find_median_from_data_stream
{
    class MedianFinder
    {
        /** initialize your data structure here. */
        PriorityQueue<Integer> lo, hi;
        
        public MedianFinder()
        {
            // max heap
            this.lo = new PriorityQueue<Integer>( (a, b) -> b - a );
            // min heap
            this.hi = new PriorityQueue<Integer>( (a, b) -> a - b );
        }
        
        public void addNum(int num)
        {
            // always insert to the max heap first
            lo.offer( num );
            // balancing
            hi.offer( lo.remove() );
            
            // lo should always have larger size
            // lo: stores 2 * n + 1
            // hi: stores 2 * n
            if( lo.size() < hi.size() ) lo.offer( hi.remove() );
        }
        
        public double findMedian()
        {
            // when the size are the same (even length of the whole list)
            //     return (lo.peek + hi.peek) / 2
            // when the length of list is odd
            //     return lo.peek
            return lo.size() > hi.size() ? (double) lo.peek() : (lo.peek() + hi.peek()) * 0.5;
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
}