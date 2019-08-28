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

// Runtime: 1 ms, faster than 95.08% of Java online submissions for Maximum Average Subtree.
// Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Maximum Average Subtree.
class Q1120_max_avg_subtree
{
    public double maximumAverageSubtree(TreeNode root)
    {
        return helper( root )[ 2 ];
    }
    
    private double[] helper( TreeNode cur )
    {
        if( cur == null ) return new double[]{ 0.0, 0.0, 0.0 }; // field { sum, count }
        
        double[] l = helper( cur.left ), r = helper( cur.right );
        
        // get the larger child
        double child = Math.max( l[ 2 ], r[ 2 ] );
        
        double sum = cur.val + l[ 0 ] + r[ 0 ],
               count = 1 + l[ 1 ] + r[ 1 ];
        // record the max
        Double maxAvg = Math.max( child, (sum / count) );
        
        return new double[]{ sum, count, maxAvg };
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}