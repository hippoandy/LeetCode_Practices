package app;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class Q339_nested_list_weight_sum
{
    int sum = 0;

    public int depthSum(List<NestedInteger> nestedList)
    {
        if( nestedList == null || nestedList.size() == 0 ) return 0;

        helper( nestedList, 1 );
        return sum;
    }
    
    private void helper( List<NestedInteger> lst, int level )
    {
        for( NestedInteger i: lst )
        {
            if( i.isInteger() )
                sum += i.getInteger() * level;
            else
                helper( i.getList(), level+1 );
        }
    }
}