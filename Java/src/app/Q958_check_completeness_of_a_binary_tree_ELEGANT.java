// ref. https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205682/JavaC%2B%2BPython-BFS-Level-Order-Traversal

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

// Runtime: 1 ms, faster than 93.26% of Java online submissions for Check Completeness of a Binary Tree.
// Memory Usage: 36.8 MB, less than 93.81% of Java online submissions for Check Completeness of a Binary Tree.
class Q958_check_completeness_of_a_binary_tree_ELEGANT
{
    public boolean isCompleteTree(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer( root );
        while( q.peek() != null )
        {
            TreeNode cur = q.remove();
            q.offer( cur.left );
            q.offer( cur.right );
        }
        // clear the null node
        while( !q.isEmpty() && q.peek() == null ) q.remove();
        
        // if the queue is not empty, then the tree is not complete!
        return q.isEmpty();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}