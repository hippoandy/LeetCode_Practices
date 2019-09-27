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
class Q549_binary_tree_longest_consecutive_seq_2
{
    int max = 0;
    public int longestConsecutive(TreeNode root)
    {
        longestPath( root );
        return max;
    }
    
    private int[] longestPath( TreeNode cur )
    {
        if( cur == null ) return new int[]{ 0, 0 }; // format: {inc, dec}
        
        int inc = 1, dec = 1;
        /** left subtree **/
        if( cur.left != null )
        {
            int[] l = longestPath( cur.left );
            if( cur.val == cur.left.val + 1 )       dec = l[ 1 ] + 1;
            else if( cur.val == cur.left.val - 1 )  inc = l[ 0 ] + 1;
        }
        /** right subtree **/
        // need to consider the left part!!
        // since we need to consider the longest sequence possible
        if( cur.right != null )
        {
            int[] r = longestPath( cur.right );
            if( cur.val == cur.right.val + 1 )      dec = Math.max( dec, r[ 1 ] + 1 );
            else if( cur.val == cur.right.val - 1 ) inc = Math.max( inc, r[ 0 ] + 1 );
        }

        max = Math.max( max, dec + inc - 1 );
        return new int[]{ inc, dec };
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}