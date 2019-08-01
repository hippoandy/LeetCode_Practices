package app;

import java.util.*;

// Runtime: 57 ms, faster than 93.60% of Java online submissions for Binary Search Tree Iterator.
// Memory Usage: 50 MB, less than 95.12% of Java online submissions for Binary Search Tree Iterator.
class Q173_binary_search_tree_iterator_SPACE_O_h
{
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class BSTIterator
    {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root)
        {
            this.stack = new Stack<TreeNode>();
            // story left subtree in stack
            this.leftMostInorder( root );
        }

        private void leftMostInorder( TreeNode cur )
        {
            while( cur != null )
            {
                this.stack.push( cur );
                cur = cur.left;
            }
        }
        
        /** @return the next smallest number */
        public int next()
        {
            TreeNode cur = this.stack.pop();
            if( cur.right != null )
                this.leftMostInorder( cur.right );
            return cur.val;
        }
        
        /** @return whether we have a next smallest number */
        public boolean hasNext()
        {
            return this.stack.size() > 0;
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}