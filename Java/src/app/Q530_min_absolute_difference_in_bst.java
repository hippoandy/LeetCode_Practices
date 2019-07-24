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
class Q530_min_absolute_difference_in_bst
{
    int min = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;

    // since it's BST, inorder traversal returns sorted list!
    public int getMinimumDifference(TreeNode root)
    {
        if( root == null ) return min;
        
        getMinimumDifference( root.left );
        
        if( pre != Integer.MAX_VALUE )
            min = Math.min( min, Math.abs( root.val - pre ) );
        pre = root.val;
        
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