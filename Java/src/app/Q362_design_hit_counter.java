// ref. https://leetcode.com/problems/design-hit-counter/discuss/83483/Super-easy-design-O(1)-hit()-O(s)-getHits()-no-fancy-data-structure-is-needed!

package app;

class Q362_design_hit_counter
{
    class HitCounter
    {
        private int[] time;
        private int[] hits;
        private int capacity = 300; // 5 minutes

        /** Initialize your data structure here. */
        public HitCounter()
        {
            this.time = new int[ this.capacity ];
            this.hits = new int[ this.capacity ];
        }
        
        /** Record a hit.
            @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp)
        {
            int idx = timestamp % this.capacity;
            // over the capacity, replace the old value
            if( this.time[ idx ] != timestamp )
            {
                this.time[ idx ] = timestamp;
                this.hits[ idx ] = 1;
            }
            else
                this.hits[ idx ] = this.hits[ idx ] + 1;
        }
        
        /** Return the number of hits in the past 5 minutes.
            @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp)
        {
            int total = 0;
            for( int i = 0; i < this.capacity; i++ )
                // earlier than 5 minutes
                if( timestamp - this.time[ i ] < this.capacity )
                    total += this.hits[ i ];
            return total;
        }
    }

    /**
     * Your HitCounter object will be instantiated and called as such:
     * HitCounter obj = new HitCounter();
     * obj.hit(timestamp);
     * int param_2 = obj.getHits(timestamp);
     */
}