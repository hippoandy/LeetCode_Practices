// ref. https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/34981/My-DFS-and-BFS-java-solution

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

// Runtime: 1 ms, faster than 96.68% of Java online submissions for Binary Tree Level Order Traversal II.
// Memory Usage: 36.5 MB, less than 99.92% of Java online submissions for Binary Tree Level Order Traversal II.
class Q107_binary_tree_level_order_traversal_2_DFS
{
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( root == null ) return ans;
        dfs( root, ans, 0 );
        return ans;
    }
    
    // postorder-liked
    private void dfs( TreeNode cur, List<List<Integer>> ans, int depth )
    {
        if( cur == null ) return;
        
        if( depth == ans.size() )
            // always add the new list at the front
            ans.add( 0, new ArrayList<Integer>() );
        
        dfs( cur.left, ans, depth+1 );
        dfs( cur.right, ans, depth+1 );
        
        ans.get( ans.size() - depth - 1 ).add( cur.val );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

// class Solution {
//     public List<List<Integer>> levelOrderBottom(TreeNode root)
//     {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         if( root == null ) return ans;
        
//         Queue<TreeNode> q = new LinkedList<TreeNode>();
//         q.offer( root );
//         while( !q.isEmpty() )
//         {
//             int len = q.size();
//             List<Integer> level = new ArrayList<Integer>();
//             for( int i = 0; i < len; i++ )
//             {
//                 TreeNode cur = q.remove();
//                 level.add( cur.val );
//                 if( cur.left != null )  q.offer( cur.left );
//                 if( cur.right != null ) q.offer( cur.right );
//             }
//             // just change the way while inserting
//             ans.add( 0, level );
//         }
//         return ans;
//     }
// }