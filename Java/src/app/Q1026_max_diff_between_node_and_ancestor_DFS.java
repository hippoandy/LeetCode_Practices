// ref. https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/274610/JavaC%2B%2BPython-Top-Down

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

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Difference Between Node and Ancestor.
// Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Maximum Difference Between Node and Ancestor.
class Q1026_max_diff_between_node_and_ancestor_DFS
{
    public int maxAncestorDiff(TreeNode root)
    {
        return dfs(root, root.val, root.val);
    }

    public int dfs( TreeNode root, int min, int max )
    {
        // At the leaf node, return max - min through the path from the root to the leaf.
        if( root == null ) return max - min;
        max = Math.max( max, root.val );
        min = Math.min( min, root.val );
        return Math.max( dfs( root.left, min, max ), dfs( root.right, min, max ) );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}