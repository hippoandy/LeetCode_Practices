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
class Q938_range_sum_of_bst
{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R)
    {
        helper( root, L, R );
        return sum;
    }
    
    private void helper( TreeNode root, int L, int R )
    {
        if( root == null ) return;
        if( root.val >= L && root.val <= R ) sum += root.val;
        helper( root.left, L, R );
        helper( root.right, L, R );
    }
}