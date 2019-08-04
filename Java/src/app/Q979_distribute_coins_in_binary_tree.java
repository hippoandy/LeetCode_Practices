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
class Q979_distribute_coins_in_binary_tree
{
    int moves = 0;

    public int distributeCoins(TreeNode root)
    {
        if( root == null ) return 0;
        dfs( root );
        return moves;
    }
    
    private int dfs( TreeNode cur )
    {
        if( cur == null ) return 0;
        
        int l = dfs( cur.left );
        int r = dfs( cur.right );
        
        moves += Math.abs( l ) + Math.abs( r );
        
        return cur.val + l + r - 1; // -1 since we have to left 1 coin at current node
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}