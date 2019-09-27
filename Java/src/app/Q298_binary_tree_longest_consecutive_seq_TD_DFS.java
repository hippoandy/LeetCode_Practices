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
class Q298_binary_tree_longest_consecutive_seq_TD_DFS
{
    int max = 0;
    public int longestConsecutive(TreeNode root)
    {
        dfs( root, null, 0 );   // root has no parent
        return max;
    }
    
    // top-down
    private void dfs( TreeNode cur, TreeNode parent, int len )
    {
        if( cur == null ) return;
        if( parent != null && cur.val == parent.val + 1 ) len++;
        // reset
        else                                              len = 1;
        // update the max
        max = (len > max) ? len: max;
        
        dfs( cur.left, cur, len );
        dfs( cur.right, cur, len );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}