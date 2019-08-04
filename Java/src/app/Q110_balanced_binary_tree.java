// ref. https://leetcode.com/problems/balanced-binary-tree/discuss/35943/JAVA-O(n)-solution-based-on-Maximum-Depth-of-Binary-Tree

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
class Q110_balanced_binary_tree
{
    private boolean result = true;

    public boolean isBalanced(TreeNode root)
    {
        if( root == null ) return true;
        maxDepth( root );
        return result;
    }
    
    public int maxDepth( TreeNode cur )
    {
        if( cur == null ) return 0;

        int l = maxDepth( cur.left );
        int r = maxDepth( cur.right );
        if( Math.abs(l - r) > 1 ) result = false;
        return 1 + Math.max( l, r );
    }
    
    // private void traverse( TreeNode cur, int level )
    // {
    //     if( cur.left == null && cur.right == null )
    //     {
    //         max = (level > max) ? level : max;
    //         min = (level < min) ? level : min;
    //     }
    //     if( cur.left != null ) traverse( cur.left, level+1 );
    //     if( cur.right != null ) traverse( cur.right, level+1 );
    // }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}