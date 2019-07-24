package app;

import java.util.*;
import java.lang.Math;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Runtime: 2 ms, faster than 73.10% of Java online submissions for Find Largest Value in Each Tree Row.
// Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Find Largest Value in Each Tree Row.
class Q515_find_largest_val_in_each_tree_row_BFS
{
    public List<Integer> largestValues(TreeNode root)
    {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null ) return ans;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer( root );

        while( !queue.isEmpty() )
        {
            int len = queue.size();
            int levelMax = Integer.MIN_VALUE;
            for( int i = 0; i < len; i++ )
            {
                TreeNode cur = queue.remove();
                if( cur.left != null )  queue.offer( cur.left );
                if( cur.right != null ) queue.offer( cur.right );
                
                levelMax = Math.max( levelMax, cur.val );
            }
            ans.add( levelMax );
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}