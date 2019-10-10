// ref. https://stackoverflow.com/questions/6536094/java-arraylist-copy

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
class Q113_path_sum_II
{
    List<List<Integer>> sol = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        find( root, sum, new ArrayList<Integer>() );
        return sol;
    }
    
    public void find( TreeNode cur, int sum, List<Integer> path)
    {
        // empty tree
        if( cur == null ) return;
        
        path.add( cur.val );

        if( cur.right == null && cur.left == null )
        {
            // after several substraction
            // we are expecting a node value to be exactly the remaining sum
            if( cur.val == sum ) sol.add( path );
            return;
        }

        // keep subtracting the sum
        find( cur.left,  (sum - cur.val), new ArrayList<Integer>( path ) );
        find( cur.right, (sum - cur.val), new ArrayList<Integer>( path ) );
        return;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}