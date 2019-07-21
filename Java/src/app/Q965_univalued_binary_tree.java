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
class Q965_univalued_binary_tree
{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int unival;
    public boolean isUnivalTree(TreeNode root)
    {
        if( root == null ) return false;

        unival = root.val;
        return helper( root );
    }
    
    private boolean helper( TreeNode root )
    {
        // leaf
        if( root == null ) return true;

        if( root.val != unival ) return false;
        return helper( root.left ) && helper( root.right );
    }
}