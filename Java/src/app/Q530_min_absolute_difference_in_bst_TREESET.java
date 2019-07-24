// ref. [SOLUTION] https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/99905/Two-Solutions-in-order-traversal-and-a-more-general-way-using-TreeSet
// ref. [Java TreeSet] https://docs.oracle.com/javase/8/docs/api/?java/util/TreeSet.html

package app;

import java.util.*;

// Follow up: What if it is not a BST?
// The idea is to put values in a TreeSet and then every time we can use O(lgN) time to lookup for the nearest values.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Runtime: 12 ms, faster than 5.50% of Java online submissions for Minimum Absolute Difference in BST.
// Memory Usage: 45.4 MB, less than 5.16% of Java online submissions for Minimum Absolute Difference in BST
class Q530_min_absolute_difference_in_bst_TREESET
{
    TreeSet<Integer> set = new TreeSet<Integer>();
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root)
    {
        if( root == null ) return min;

        if( !set.isEmpty() )
        {
            // Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
            if( set.floor( root.val ) != null )
                min = Math.min( min, Math.abs( root.val - set.floor( root.val ) ) );
            // Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
            if( set.ceiling( root.val ) != null )
                min = Math.min( min, Math.abs( root.val - set.ceiling( root.val ) ) );
        }

        set.add( root.val );

        getMinimumDifference( root.left );
        getMinimumDifference( root.right );

        return min;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}