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

// Runtime: 2 ms, faster than 10.98% of Java online submissions for Check Completeness of a Binary Tree.
// Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Check Completeness of a Binary Tree.
class Q958_check_completeness_of_a_binary_tree
{
    public boolean isCompleteTree(TreeNode root)
    {
        List<AnnotatedNode> nodes = new ArrayList<AnnotatedNode>();
        nodes.add( new AnnotatedNode( root, 1 ) );
        int i = 0;
        while( i < nodes.size() )
        {
            AnnotatedNode n = nodes.get( i );
            if( n.node != null )
            {
                nodes.add( new AnnotatedNode( n.node.left,  n.pos * 2 ) );
                nodes.add( new AnnotatedNode( n.node.right, n.pos * 2 + 1 ) );
            }
            i++;
        }
        // notes that there will be dummy entries in the list!
        return nodes.get( i-1 ).pos == nodes.size();
    }
    
    class AnnotatedNode
    {
        TreeNode node;
        int pos;
        
        public AnnotatedNode( TreeNode node, int pos )
        {
            this.node = node;
            this.pos = pos;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}