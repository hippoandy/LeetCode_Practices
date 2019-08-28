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

// Runtime: 2 ms, faster than 99.69% of Java online submissions for Maximum Binary Tree.
// Memory Usage: 38.6 MB, less than 91.30% of Java online submissions for Maximum Binary Tree.
class Q654_max_binary_tree
{
    public TreeNode constructMaximumBinaryTree(int[] nums)
    {
        if( nums == null || nums.length == 0 ) return null;
        int n = nums.length;
        return helper( nums, 0, n-1 );
    }
    
    private TreeNode helper( int[] nums, int l, int r )
    {
        if( r < l ) return null;
        
        // find the max
        int idx = 0;
        int max = -1;
        for( int i = l; i <= r; i++ )
            if( nums[ i ] > max )
            {
                idx = i;
                max = nums[ i ];
            }
        // create the root node
        TreeNode cur = new TreeNode( nums[ idx ] );
        cur.left = helper( nums, l, idx-1 );
        cur.right = helper( nums, idx+1, r );
        
        return cur;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}