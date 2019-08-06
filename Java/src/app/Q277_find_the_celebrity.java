// ref. https://leetcode.com/problems/find-the-celebrity/discuss/71227/Java-Solution.-Two-Pass

package app;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b);
      // get information of whether A knows B
 */

public class Q277_find_the_celebrity extends Relation
{
    public int findCelebrity(int n)
    {    
        int candi = 0;
        for( int i = 1; i < n; i++ )
            // the celebrity shouldn't know any other people in the party
            if( knows( candi, i ) )
                candi = i;
        
        // verify the candi
        for( int i = 0; i < n; i++ )
            // if the candi knows someone else or someone doesn't know the candi
            if( i != candi && knows( candi, i ) || !knows( i, candi ) ) return -1;
        return candi;
    }
}