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

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
// Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Binary Tree Paths.
class Q257_binary_tree_paths
{
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root)
    {
        ans = new ArrayList<String>();
        if( root == null ) return ans;
        dfs( root, "" );
        return ans;
    }
    
    private void dfs( TreeNode cur, String tmp )
    {
        if( cur == null ) return;
        // found a leaf node
        if( cur.left == null && cur.right == null )
        {
            tmp += Integer.toString( cur.val );
            ans.add( tmp );
            return;
        }
        tmp += Integer.toString( cur.val ) + "->";
        dfs( cur.left, tmp );
        dfs( cur.right, tmp );
    }

    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}