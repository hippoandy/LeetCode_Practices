// ref. https://stackoverflow.com/questions/3884793/why-is-double-min-value-in-not-negative

package app;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q98_validate_binary_search_tree
{
    int pre = 0;
    public boolean isValidBST(TreeNode root)
    {
        // int pre = Integer.MIN_VALUE;
        // to prevent overflow for test case: [-2147483648]
        double pre = -Double.MAX_VALUE; // see reference
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while( !stack.isEmpty() || root != null )
        {
            // get to the leftmost leaf
            while( root != null )
            {
                stack.push( root );
                root = root.left;
            }
            root = stack.pop();

            if( root.val <= pre ) return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}