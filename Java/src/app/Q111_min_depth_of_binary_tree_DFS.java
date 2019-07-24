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
class Q111_min_depth_of_binary_tree_DFS
{
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root)
    {
        if( root == null ) return 0;
        dfs( root, 0 );
        return minDepth;
    }
    
    private void dfs( TreeNode cur, int depth )
    {
        depth++;
        // a leaf node
        if( cur.left == null && cur.right == null )
        {
            minDepth = Math.min( minDepth, depth );
            return;
        }
        if( cur.left != null )  dfs( cur.left, depth );
        if( cur.right != null ) dfs( cur.right, depth );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}