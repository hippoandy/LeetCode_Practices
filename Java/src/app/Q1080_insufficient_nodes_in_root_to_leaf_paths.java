// ref. https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/discuss/308326/JavaC%2B%2BPython-Easy-and-Concise-Recursion

package app;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Insufficient Nodes in Root to Leaf Paths.
// Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Insufficient Nodes in Root to Leaf Paths.
class Q1080_insufficient_nodes_in_root_to_leaf_paths
{
    public TreeNode sufficientSubset(TreeNode cur, int limit)
    {
        if( cur == null ) return null;
        // case: root is leaf
        if( cur.left == null && cur.right == null )
            // don't reverse the logic!
            return (cur.val < limit) ? null : cur;

        cur.left  = sufficientSubset( cur.left,  (limit - cur.val) );
        cur.right = sufficientSubset( cur.right, (limit - cur.val) );
        
        // no more node on the current path
        if( cur.left == cur.right )
            return null;
        else
            return cur;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}