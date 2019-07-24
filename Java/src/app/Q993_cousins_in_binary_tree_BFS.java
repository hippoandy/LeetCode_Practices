// ref. https://leetcode.com/problems/cousins-in-binary-tree/discuss/242789/Java-Summary-of-2-solutions

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
class Q993_cousins_in_binary_tree_BFS
{
    public static boolean isCousins(TreeNode root, int x, int y)
    {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        TreeNode xParent = null, yParent = null;
        q.offer( root );

        while( !q.isEmpty() )
        {
            int len = q.size();
            
            for( int i = 0; i < len; i++ )
            {
                TreeNode cur = q.remove();
                if( cur.left != null )
                {
                    if( cur.left.val == x ) xParent = cur;
                    if( cur.left.val == y ) yParent = cur;
                    q.offer( cur.left );
                }
                if( cur.right != null )
                {
                    if( cur.right.val == x ) xParent = cur;
                    if( cur.right.val == y ) yParent = cur;
                    q.offer( cur.right );
                }
                if( xParent != null && yParent != null ) break;
            }
            // check if the two node share the same parent
            if( xParent != null && yParent != null ) return xParent != yParent;
            // one of the node not found
            if( (xParent != null && yParent == null) || 
                (xParent == null && yParent != null) ) return false;
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}