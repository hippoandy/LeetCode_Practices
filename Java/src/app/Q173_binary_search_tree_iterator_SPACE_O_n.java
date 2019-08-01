package app;

import java.util.*;

// Space complexity: O(n)
// Runtime: 57 ms, faster than 93.60% of Java online submissions for Binary Search Tree Iterator.
// Memory Usage: 49.8 MB, less than 95.28% of Java online submissions for Binary Search Tree Iterator.
class Q173_binary_search_tree_iterator_SPACE_O_n
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
        List<Integer> inorder;
        int idx;
        int size;
        public BSTIterator(TreeNode root)
        {
            this.inorder = new ArrayList<Integer>();
            this.idx = 0;
            // store the elements in a sorted list
            this.inorder( root );
        }
        
        private void inorder( TreeNode cur )
        {
            if( cur == null ) return;
            if( cur.left != null ) inorder( cur.left );
            this.inorder.add( cur.val );
            this.size++;
            if( cur.right != null ) inorder( cur.right );
        }
        
        /** @return the next smallest number */
        public int next()
        {
            int ret = this.inorder.get( this.idx );
            this.idx++;
            return ret;
        }
        
        /** @return whether we have a next smallest number */
        public boolean hasNext()
        {
            if( this.idx < this.size ) return true;
            return false;
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