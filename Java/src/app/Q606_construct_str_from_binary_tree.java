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
class Q606_construct_str_from_binary_tree
{
    public String tree2str(TreeNode t)
    {
        if( t == null ) return "";
        // leaf node
        // considering empty braces for the null left and right children is redundant
        if( t.left == null && t.right == null ) return Integer.toString( t.val );
        // case: no right subtree
        if( t.right == null )
            return Integer.toString( t.val ) + "(" + tree2str( t.left ) + ")";
        // case: both left and right tree exists
        return Integer.toString( t.val ) + "(" + tree2str( t.left ) + ")(" + tree2str( t.right ) + ")";
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}