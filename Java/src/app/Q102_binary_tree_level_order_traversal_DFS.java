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

class Q102_binary_tree_level_order_traversal_DFS
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( root == null ) return ans;
        ans.add( new ArrayList<Integer>() );
        dfs( root, ans, 0 );
        return ans;
    }
    
    private void dfs( TreeNode cur, List<List<Integer>> ans, int depth )
    {
        if( cur == null ) return;
        
        if( depth == ans.size() )
            ans.add( new ArrayList<Integer>() );

        ans.get( depth ).add( cur.val );
        
        dfs( cur.left, ans, depth+1 );
        dfs( cur.right, ans, depth+1 );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root)
//     {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         if( root == null ) return ans;
        
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.offer( root );
//         while( !queue.isEmpty() )
//         {
//             List<Integer> level = new ArrayList<Integer>();
//             int len = queue.size();
//             for( int i = 0; i < len; i++ )
//             {
//                 TreeNode cur = queue.remove();
//                 level.add( cur.val );
//                 if( cur.left != null )  queue.add( cur.left );
//                 if( cur.right != null ) queue.add( cur.right );                
//             }
//             ans.add( level );
//         }
//         return ans;
//     }
// }