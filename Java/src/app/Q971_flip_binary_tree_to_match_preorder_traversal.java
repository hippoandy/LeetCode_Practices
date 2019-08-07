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

// Runtime: 1 ms, faster than 56.37% of Java online submissions for Flip Binary Tree To Match Preorder Traversal.
// Memory Usage: 38.2 MB, less than 93.33% of Java online submissions for Flip Binary Tree To Match Preorder Traversal.
class Q971_flip_binary_tree_to_match_preorder_traversal
{
    List<Integer> ans = new ArrayList<Integer>();
    int idx = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage)
    {
        dfs( root, voyage );
        if( ans.size() != 0 && ans.get( 0 ) == -1 )
        {
            ans.clear();
            ans.add( -1 );
        }
        return ans;
    }
    
    private void dfs( TreeNode cur, int[] pre )
    {
        if( cur != null )
        {
            if( cur.val != pre[ idx ] )
            {
                ans.clear(); ans.add( -1 );
                return;
            }

            // check the next
            idx++;
            if( idx < pre.length && cur.left != null && cur.left.val != pre[ idx ] )
            {
                ans.add( cur.val );
                // flip
                dfs( cur.right, pre );
                dfs( cur.left, pre );
            }
            else
            {
                // normal preorder traversal
                dfs( cur.left, pre );
                dfs( cur.right, pre );
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}