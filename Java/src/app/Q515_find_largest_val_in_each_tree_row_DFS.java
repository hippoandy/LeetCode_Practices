// ref. https://leetcode.com/problems/find-largest-value-in-each-tree-row/discuss/98971/9ms-JAVA-DFS-solution

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

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Largest Value in Each Tree Row.
// Memory Usage: 38.6 MB, less than 96.85% of Java online submissions for Find Largest Value in Each Tree Row.
class Q515_find_largest_val_in_each_tree_row_DFS
{
    public List<Integer> largestValues(TreeNode root)
    {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null ) return ans;
        dfs( root, ans, 0 );
        return ans;
    }
    
    private void dfs( TreeNode cur, List<Integer> res, int depth )
    {
        if( cur == null ) return;
        
        // expand list size
        if( depth == res.size() )   res.add( cur.val );
        // set the value
        else
            // depth as index, val as value
            res.set( depth, Math.max( res.get( depth ), cur.val ) );
        dfs( cur.left, res, depth + 1 );
        dfs( cur.right, res, depth + 1 );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

// BFS
// class Solution {
//     public List<Integer> largestValues(TreeNode root)
//     {
//         List<Integer> ans = new ArrayList<Integer>();
//         if( root == null ) return ans;
        
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.offer( root );

//         while( !queue.isEmpty() )
//         {
//             int len = queue.size();
//             int levelMax = Integer.MIN_VALUE;
//             for( int i = 0; i < len; i++ )
//             {
//                 TreeNode cur = queue.remove();
//                 if( cur.left != null )  queue.offer( cur.left );
//                 if( cur.right != null ) queue.offer( cur.right );
                
//                 levelMax = Math.max( levelMax, cur.val );
//             }
//             ans.add( levelMax );
//         }
//         return ans;
//     }
// }