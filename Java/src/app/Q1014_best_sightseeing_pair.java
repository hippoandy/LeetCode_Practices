// ref. https://leetcode.com/problems/best-sightseeing-pair/discuss/260850/JavaC%2B%2BPython-One-Pass

package app;

class Q1014_best_sightseeing_pair
{
    public int maxScoreSightseeingPair(int[] A)
    {
        // "cur" records the best score we have met
        int res = 0, cur = 0;
        for( int a: A )
        {
            res = Math.max( res, cur + a );
            cur = Math.max( cur, a ) - 1;
        }
        return res;
    }
}