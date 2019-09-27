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
class Q298_binary_tree_longest_consecutive_seq_DFS_BU
{
    int max = 0;
    public int longestConsecutive(TreeNode root)
    {
        dfs( root );   // root has no parent
        return max;
    }
    
    // bottom-up
    private int dfs( TreeNode cur )
    {
        if( cur == null ) return 0;

        // keep going to the leaf
        int l = dfs( cur.left ) + 1, r = dfs( cur.right ) + 1;
        // reset if it's not consecutive
        if( cur.left != null && cur.val != cur.left.val - 1 )   l = 1;
        if( cur.right != null && cur.val != cur.right.val - 1 ) r = 1;
        
        int len = Math.max( l, r );
        // record the max
        // if the path exist in the middle, not including the root
        // then the value will be forgotten due to line 27 & 28
        max = (len > max) ? len : max;
        return len;
    }
    
    // // top-down
    // private int dfs( TreeNode cur, TreeNode parent, int len )
    // {
    //     if( cur == null ) return 0;
    //     if( parent != null && cur.val == parent.val + 1 ) len++;
    //     // reset
    //     else                                              len = 1;
    //     // get the max
    //     int childMax = Math.max(
    //         dfs( cur.left, cur, len ),
    //         dfs( cur.right, cur, len )
    //     );
    //     return Math.max( len, childMax );
    // }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}