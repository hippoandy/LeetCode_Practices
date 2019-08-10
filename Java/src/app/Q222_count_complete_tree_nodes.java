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
class Q222_count_complete_tree_nodes
{
    // linear time
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
    // Memory Usage: 40.4 MB, less than 58.54% of Java online submissions for Count Complete Tree Nodes.
    public int countNodes(TreeNode root)
    {
        return root != null ? 1 + countNodes( root.right ) + countNodes( root.left ) : 0;
    }

    // // Runtime: 6 ms, faster than 9.03% of Java online submissions for Count Complete Tree Nodes.
    // // Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Count Complete Tree Nodes.
    // public int countNodes(TreeNode root)
    // {
    //     Queue<TreeNode> q = new LinkedList<TreeNode>();
    //     q.offer( root );
    //     int count = 0;
    //     while( !q.isEmpty() && q.peek() != null )
    //     {
    //         TreeNode cur = q.remove();
    //         count++;
    //         q.offer( cur.left );
    //         q.offer( cur.right );
    //     }
    //     return count;
    // }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}