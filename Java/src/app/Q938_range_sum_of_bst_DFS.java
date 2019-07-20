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

 // 0ms, faster than pure tree traversal
class Q938_range_sum_of_bst_DFS
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
        dfs( root, L, R );
        return sum;
    }
    
    private void dfs( TreeNode root, int L, int R )
    {
        if( root == null ) return;
        if( root.val >= L && root.val <= R ) sum += root.val;
        if( root.val > L )
            dfs( root.left, L, R );
        if( root.val < R )
            dfs( root.right, L, R );
    }
}