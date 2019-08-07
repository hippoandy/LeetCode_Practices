// In the case w = [1, 99] , your pickIndex() should return 1 for 99% and 0 for 1%.

package app;

import java.util.*;

class Q528_random_pick_with_weight
{
    class Solution
    {
        List<Integer> prefix_sum = new ArrayList<Integer>();
        int sum;
        Random rand = new Random();

        public Solution(int[] w)
        {
            for( int i: w )
            {
                this.sum += i;
                // store the prefix sum
                prefix_sum.add( this.sum );
            }
        }
        
        public int pickIndex()
        {
            int target = this.rand.nextInt( this.sum );
            
            int l = 0, h = this.prefix_sum.size() - 1;
            while( l != h )
            {
                int m = l + (h - l) / 2;
                if( target >= this.prefix_sum.get( m ) )
                    l = m + 1;
                else
                    h = m;
            }
            // the problem requires the index to be returned
            return l;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
}