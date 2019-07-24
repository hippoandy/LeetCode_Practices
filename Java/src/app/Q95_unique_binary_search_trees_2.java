// ref. https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution

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
class Q95_unique_binary_search_trees_2
{
    public List<TreeNode> generateTrees(int n)
    {
        if( n <= 0 ) return new ArrayList<TreeNode>();
        // 1...n is the inorder traversal for all BST!!
        return genTree( 1, n );
    }
    
    private List<TreeNode> genTree( int start, int end )
    {
        // store the subtree, regenerate at every recursion
        List<TreeNode> res = new ArrayList<TreeNode>();
        // case for the subtree not exist
        if( start > end )
        {
            res.add( null );
            return res;
        }
        if( start == end )
        {
            res.add( new TreeNode( start ) );
            return res;
        }
        
        List<TreeNode> left, right;
        for( int i = start; i <= end; i++ )
        {
            left  = genTree( start, i - 1 );
            right = genTree( i + 1, end   );
            // all the possible subtree for the current root
            for( TreeNode l: left )
                for( TreeNode r: right )
                {
                    // use every n as root in list 1...n
                    TreeNode root = new TreeNode( i );
                    root.left = l;
                    root.right = r;
                    res.add( root );
                }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}