package app;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
 * }
 */
class Q545_boundary_of_binary_tree
{
    public List<Integer> boundaryOfBinaryTree(TreeNode root)
    {
        List<Integer> res = new ArrayList<Integer>();
        if( root == null ) return res;
        
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> bottom = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        
        /* flag:
         *   0 -> root
         *   1 -> left
         *   2 -> right
         *   3 -> other
         */
        traversal( root, left, bottom, right, 0 );
        
        left.addAll( bottom );
        left.addAll( right );
        return left;
    }

    private boolean isRoot( int flag ) { return flag == 0; }
    private boolean isLeaf( TreeNode cur ) { return cur.left == null && cur.right == null; }

    private boolean isLeftBoundary( int flag ) { return flag == 1; }
    private boolean isRightBoundary( int flag ) { return flag == 2; }
    
    private int setLeftFlag( TreeNode cur, int flag )
    {
        if( isLeftBoundary( flag ) || isRoot( flag ) ) return 1;
        else if( isRightBoundary( flag ) && cur.right == null ) return 2;
        else return 3;
    }
    
    private int setRightFlag( TreeNode cur, int flag )
    {
        if( isRightBoundary( flag ) || isRoot( flag ) ) return 2;
        else if( isLeftBoundary( flag ) && cur.left == null ) return 1;
        else return 3;
    }
    
    private void traversal( TreeNode cur, List<Integer> left, List<Integer> bottom, List<Integer> right, int flag )
    {
        if( cur == null ) return;

        if( isRightBoundary( flag ) )
            // insert from head
            right.add( 0, cur.val );
        else if( isLeftBoundary( flag ) || isRoot( flag ) )
            left.add( cur.val );
        else if( isLeaf( cur ) )
            bottom.add( cur.val );
        
        // preorder traversal
        traversal( cur.left, left, bottom, right, setLeftFlag( cur, flag ) );
        traversal( cur.right, left, bottom, right, setRightFlag( cur, flag ) );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}