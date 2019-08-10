// ref. https://leetcode.com/problems/count-univalue-subtrees/discuss/67644/AC-clean-Java-solution

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
class Q250_count_univalue_subtrees
{
    int count = 0;

    public int countUnivalSubtrees(TreeNode root)
    {
        // as a sub-tree, start considering only at the leaves (bottom-up)
        helper( root );
        return count;
    }
    
    private boolean helper( TreeNode cur )
    {
        if( cur == null ) return true;
        
        boolean l = helper( cur.left );
        boolean r = helper( cur.right );
        
        if( (l && r) &&
            (cur.left == null || cur.left.val == cur.val) &&
            (cur.right == null || cur.right.val == cur.val)
        )
        {
            count += 1;
            return true;
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}