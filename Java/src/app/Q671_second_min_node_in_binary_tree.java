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
class Q671_second_min_node_in_binary_tree
{
    public int findSecondMinimumValue(TreeNode root)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        helper( heap, root );
        int min = heap.peek();
        // there is a test case will cause overflow
        long ans = Long.MAX_VALUE;
        for( int v: heap )
            if( min < v && v < ans )
                ans = v;
        return (ans != Long.MAX_VALUE) ? (int) ans : -1;
    }
    
    private void helper( PriorityQueue<Integer> heap, TreeNode cur )
    {
        if( cur == null ) return;
        
        heap.offer( cur.val );
        helper( heap, cur.left );
        helper( heap, cur.right );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}