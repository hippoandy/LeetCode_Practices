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
class Q199_binary_tree_right_side_view
{
    public List<Integer> rightSideView(TreeNode root)
    {
        Map<Integer, Integer> rightMostAtLevel = new HashMap<Integer, Integer>();
        int maxDepth = -1;

        // these 2 stack will be synchronized
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        
        nodeStack.push( root );
        depthStack.push( 0 );
        
        while( !nodeStack.isEmpty() )
        {
            TreeNode n = nodeStack.pop();
            int depth = depthStack.pop();
            
            if( n != null )
            {
                maxDepth = (depth > maxDepth) ? depth : maxDepth;
                
                // when encounter the left nodes, they will be ignore
                if( !rightMostAtLevel.containsKey( depth ) )
                    rightMostAtLevel.put( depth, n.val );
                
                // make sure the right most node is on the top of the stack
                nodeStack.push( n.left );
                nodeStack.push( n.right );
                depthStack.push( depth+1 );
                depthStack.push( depth+1 );
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for( int d = 0; d <= maxDepth; d++ )
            ans.add( rightMostAtLevel.get( d ) );
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}