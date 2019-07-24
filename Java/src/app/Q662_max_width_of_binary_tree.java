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

/* 
 * The main idea in this question is to give each node a position value.
 * If we go down the left neighbor, then position -> position * 2;
 * and if we go down the right neighbor, then position -> position * 2 + 1.
 * This makes it so that when we look at the position values L and R of two nodes with the same depth,
 * the width will be R - L + 1.
 */
class Q662_max_width_of_binary_tree
{
    int max = Integer.MIN_VALUE;
    public int widthOfBinaryTree(TreeNode root)
    {
        Queue<AnnotatedNode> q = new LinkedList<AnnotatedNode>();
        // (node, depth, pos)
        q.offer( new AnnotatedNode( root, 0, 0 ) );
        int curDepth = 0, left = 0, ans = 0;
        while( !q.isEmpty() )
        {
            AnnotatedNode a = q.remove();
            if( a.node != null )
            {
                // since the null subtree should be counted if siblings are exists
                // left subtree
                q.offer( new AnnotatedNode( a.node.left, a.depth + 1, a.pos * 2 ) );
                // right subtree
                q.offer( new AnnotatedNode( a.node.right, a.depth + 1, a.pos * 2 + 1 ) );
                
                if( curDepth != a.depth )
                {
                    curDepth = a.depth;
                    left = a.pos;
                }
                // width = right - left + 1
                ans = Math.max( ans, a.pos - left + 1 );
            }
        }
        return ans;
    }
    
    class AnnotatedNode
    {
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}