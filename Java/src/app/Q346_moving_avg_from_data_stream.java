package app;

import java.util.*;

class Q346_moving_avg_from_data_stream
{
    class MovingAverage
    {
        Queue<Integer> q;
        double sum;
        int capacity;

        /** Initialize your data structure here. */
        public MovingAverage(int size)
        {
            this.q = new LinkedList<Integer>();
            this.sum = 0;
            this.capacity = size;
        }
        
        public double next(int val)
        {
            this.sum += val;
            this.q.offer( val );
            if( this.q.size() > this.capacity )
            {
                int pop = this.q.remove();
                this.sum -= pop;
            }
            return this.sum / this.q.size();
        }
    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
}