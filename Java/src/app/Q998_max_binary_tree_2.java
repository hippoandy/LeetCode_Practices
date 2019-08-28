// ref. https://leetcode.com/problems/maximum-binary-tree-ii/discuss/242936/JavaC%2B%2BPython-Recursion-and-Iteration

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
class Q998_max_binary_tree_2
{
    public TreeNode insertIntoMaxTree(TreeNode root, int val)
    {
        // put to left
        if( root != null && root.val > val )
        {
            root.right = insertIntoMaxTree( root.right, val );
            return root;
        }
        TreeNode n = new TreeNode( val );
        n.left = root;
        return n;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}