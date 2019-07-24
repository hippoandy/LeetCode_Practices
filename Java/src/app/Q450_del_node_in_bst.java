// ref. https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution

package app;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
// Memory Usage: 39.7 MB, less than 40.31% of Java online submissions for Delete Node in a BST.
class Q450_del_node_in_bst
{
    public TreeNode deleteNode(TreeNode cur, int key)
    {
        if( cur == null ) return null;
        
        // find in the left subtree
        if( key < cur.val )
            cur.left = deleteNode( cur.left, key );
        else if( key > cur.val )
            cur.right = deleteNode( cur.right, key );
        else
        {
            // if only one of the sub-tree exist, direct connect it to the parent
            if( cur.left == null )  return cur.right;
            if( cur.right == null ) return cur.left;
            
            TreeNode rightMin = cur.right;
            while( rightMin.left != null ) rightMin = rightMin.left;
            // save the old left subtree of the to be deleted node
            rightMin.left = cur.left;
            return cur.right;
        }
        // nothing to do
        return cur;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}