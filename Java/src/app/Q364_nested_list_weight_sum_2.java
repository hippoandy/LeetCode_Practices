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
class Q364_nested_list_weight_sum_2
{
    // store the number for each level
    Map<Integer, List<Integer>> map;
    // record the max level
    int max_level = 0;

    public int depthSumInverse(List<NestedInteger> nestedList)
    {
        if( nestedList == null || nestedList.size() == 0 ) return 0;

        // build the map
        map = new HashMap<Integer, List<Integer>>();
        helper( nestedList, 1 );

        // get the answer
        int sum = 0;
        for( int i = 1; i <= max_level; i++ )
        {
            // for example, case [[0],[0],[0]] have number for level 2, but no number in level 1
            if( map.containsKey( i ) )
                for( int n: map.get( i ) )
                    // (max_level - i + 1) is to reverse the level
                    sum += (max_level - i + 1) * n;
        }
        return sum;
    }
    
    private void helper( List<NestedInteger> lst, int level )
    {
        // record the max height of the nested list
        max_level = (level > max_level) ? level : max_level;

        // same logic as the previous problem (LeetCode Q339)
        for( NestedInteger i: lst )
        {
            if( i.isInteger() )
            {
                if( !map.containsKey( level ) )
                    map.put( level, new ArrayList<Integer>() );
                map.get( level ).add( i.getInteger() );
            }
            else
                helper( i.getList(), level+1 );
        }
    }
}