package app;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
 * }
 */
class Q572_subtree_of_another_tree
{
    public boolean isSubtree(TreeNode s, TreeNode t)
    {
        return traverse( s, t );
    }
    
    // check equal
    private boolean isEqual( TreeNode x, TreeNode y )
    {
        if( x == null && y == null ) return true;
        if( x == null || y == null ) return false;
        return x.val == y.val && isEqual( x.left, y.left ) && isEqual( x.right, y.right );
    }
    
    // find the start point
    public boolean traverse( TreeNode s, TreeNode t )
    {
        return s != null && (
            isEqual( s, t ) ||
            // try to find the start point
            traverse( s.left, t ) ||
            traverse( s.right, t )
        );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}