package app;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// Runtime: 2 ms, faster than 100.00% of Java online submissions for Flatten Nested List Iterator.
// Memory Usage: 37 MB, less than 100.00% of Java online submissions for Flatten Nested List Iterator.
public class NestedIterator implements Iterator<Integer>
{
    Queue<Integer> q;

    public NestedIterator(List<NestedInteger> nestedList)
    {
        q = new LinkedList<Integer>();
        // generate the list
        helper( nestedList, q );
    }
    
    private void helper( List<NestedInteger> nestedList, Queue<Integer> q )
    {
        for( NestedInteger i: nestedList )
        {
            if( i.isInteger() ) q.offer( i.getInteger() );
            else
                helper( i.getList(), q );
        }
    }

    @Override
    public Integer next()
    {
        return (!q.isEmpty()) ? q.remove() : null;
    }

    @Override
    public boolean hasNext()
    {
        return !q.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */