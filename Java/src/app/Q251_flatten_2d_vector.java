// ref. https://leetcode.com/problems/flatten-2d-vector/discuss/350397/Java-Solution-using-1-Queue

package app;

import java.util.*;

class Q251_flatten_2d_vector
{
    class Vector2D
    {
        Queue<Iterator<Integer>> q;

        public Vector2D(int[][] v)
        {
            q = new LinkedList<Iterator<Integer>>();
            for( int[] x: v )
            {
                if( x.length != 0 )
                    q.add( Arrays.stream( x ).iterator() );
            }
        }
        
        public int next()
        {
            if( q.peek().hasNext() ) return q.peek().next();

            q.remove();
            return next();
        }
        
        public boolean hasNext()
        {
            if( q.isEmpty() ) return false;
            if( q.peek().hasNext() ) return true;
            
            q.remove();
            return hasNext();
        }
    }

    /**
     * Your Vector2D object will be instantiated and called as such:
     * Vector2D obj = new Vector2D(v);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}