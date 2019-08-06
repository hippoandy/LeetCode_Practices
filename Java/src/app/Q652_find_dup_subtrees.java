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
class Q652_find_dup_subtrees
{
    Map<String, Integer> map;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root)
    {
        map = new HashMap<String, Integer>();
        ans = new ArrayList<TreeNode>();
        
        dfs( root );
        return ans;
    }
    
    private String dfs( TreeNode cur )
    {
        if( cur == null ) return "#";
        
        String serial = cur.val + "," + dfs( cur.left ) + "," + dfs( cur.right );
        map.put( serial, map.getOrDefault( serial, 0 ) + 1 );
        // found duplicate subtree
        if( map.get( serial ) == 2 )
            ans.add( cur );
        return serial;
    }
}