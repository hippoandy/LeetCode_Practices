package app;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Maximum Path Sum.
// Memory Usage: 40.1 MB, less than 98.81% of Java online submissions for Binary Tree Maximum Path Sum.
class Q124_binary_tree_max_path_sum
{
    int maxSum = Integer.MIN_VALUE;
    
    private int maxGain( TreeNode cur )
    {
        // base case
        if( cur == null ) return 0;

        int lGain = Math.max( maxGain( cur.left ), 0 );
        int rGain = Math.max( maxGain( cur.right ), 0 );
        
        // this path will not include the parent of the current node
        int newPath = cur.val + lGain + rGain;
        
        // record the max if the path without parent node will be the max
        maxSum = Math.max( maxSum, newPath );
        
        // choose max subtree including current node for recursion
        // this path will include the parent of the current node
        return cur.val + Math.max( lGain, rGain );
    }
    
    public int maxPathSum(TreeNode root)
    {
        maxGain( root );
        return maxSum;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}