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

// Runtime: 235 ms, faster than 5.16% of Java online submissions for Maximum Difference Between Node and Ancestor.
// Memory Usage: 38.1 MB, less than 8.40% of Java online submissions for Maximum Difference Between Node and Ancestor.
class Q1026_max_diff_between_node_and_ancestor
{
    int max = Integer.MIN_VALUE;
    Stack<TreeNode> parent = new Stack<TreeNode>();

    public int maxAncestorDiff(TreeNode root)
    {
        if( root == null ) return 0;
        traverse( root );
        return max;
    }
    
    private void traverse( TreeNode cur )
    {
        if( cur == null ) return;
        
        int diff = 0;
        if( !parent.isEmpty() )
        {
            // compare with all the ancestor
            for( TreeNode p: parent )
                diff = Math.max( Math.abs( cur.val - p.val ), diff );
        }
        max = (diff > max) ? diff : max;

        parent.push( cur );
        traverse( cur.left );
        traverse( cur.right );
        // pop current parent
        parent.pop();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}