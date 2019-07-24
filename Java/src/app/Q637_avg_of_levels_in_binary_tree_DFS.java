// ref. https://leetcode.com/problems/average-of-levels-in-binary-tree/discuss/105131/A-good-problem-to-practice-(BFS-%2B-DFS)

package app;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Runtime: 2 ms, faster than 98.25% of Java online submissions for Average of Levels in Binary Tree.
// Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Average of Levels in Binary Tree.
class Q637_avg_of_levels_in_binary_tree_DFS
{
    public List<Double> averageOfLevels(TreeNode root)
    {
        // count num of nodes for each level
        List<Integer> count = new ArrayList<Integer>();
        List<Double> res = new ArrayList<Double>();
        dfs( root, res, count, 0 );
        for( int i = 0; i < res.size(); i++ )
            res.set( i, res.get( i ) / count.get( i ) );
        return res;
    }
    
    private void dfs( TreeNode cur, List<Double> sum, List<Integer> count, int depth )
    {
        if( cur == null ) return;

        if( depth < sum.size() )
        {
            sum.set( depth, sum.get( depth ) + cur.val );
            count.set( depth, count.get( depth ) + 1 );
        }
        else
        {
            sum.add( (double) cur.val );
            count.add( 1 );
        }
        
        if( cur.left != null )  dfs( cur.left, sum, count, depth + 1 );
        if( cur.right != null ) dfs( cur.right, sum, count, depth + 1 );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}