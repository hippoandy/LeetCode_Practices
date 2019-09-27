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

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Longest Consecutive Sequence.
// Memory Usage: 40.5 MB, less than 100.00% of Java online submissions for Binary Tree Longest Consecutive Sequence.
class Q298_binary_tree_longest_consecutive_seq_TD_DFS
{
    // top-down logic improved: no global needed
    public int longestConsecutive(TreeNode root)
    {
        return dfs( root, null, 0 );   // root has no parent
    }
    
    // top-down
    private int dfs( TreeNode cur, TreeNode parent, int len )
    {
        if( cur == null ) return 0;
        if( parent != null && cur.val == parent.val + 1 ) len++;
        // reset
        else                                              len = 1;
        // get the max
        int childMax = Math.max(
            dfs( cur.left, cur, len ),
            dfs( cur.right, cur, len )
        );
        return Math.max( len, childMax );
    }

    // // top-down
    // int max = 0;
    // public int longestConsecutive(TreeNode root)
    // {
    //     dfs( root, null, 0 );   // root has no parent
    //     return max;
    // }
    
    // private void dfs( TreeNode cur, TreeNode parent, int len )
    // {
    //     if( cur == null ) return;
    //     if( parent != null && cur.val == parent.val + 1 ) len++;
    //     // reset
    //     else                                              len = 1;
    //     // update the max
    //     max = (len > max) ? len: max;
        
    //     dfs( cur.left, cur, len );
    //     dfs( cur.right, cur, len );
    // }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}