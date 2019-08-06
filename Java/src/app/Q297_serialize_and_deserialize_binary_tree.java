// ref. https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74264/Short-and-straight-forward-BFS-Java-code-with-a-queue

package app;

import java.util.*;

class Q297_serialize_and_deserialize_binary_tree
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root)
        {
            if( root == null ) return "null";

            StringBuilder sb = new StringBuilder();
            // level-order
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer( root );
            while( !q.isEmpty() )
            {
                TreeNode cur = q.remove();
                if( cur == null )
                {
                    sb.append( "null," );
                    continue;
                }
                sb.append( cur.val + "," );
                q.offer( cur.left );
                q.offer( cur.right );
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data)
        {
            String[] nodes = data.split( "," );
            
            if( nodes[ 0 ].equals( "null" ) ) return null;
            
            TreeNode root = new TreeNode( Integer.parseInt( nodes[ 0 ] ) );
            
            // level-order
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer( root );
            for( int i = 1; i < nodes.length; i++ )
            {
                TreeNode cur = q.remove();
                if( !nodes[ i ].equals( "null" ) )
                {
                    TreeNode left = new TreeNode( Integer.parseInt( nodes[ i ] ) );
                    cur.left = left;
                    q.add( left );
                }
                i++;
                if( !nodes[ i ].equals( "null" ) )
                {
                    TreeNode right = new TreeNode( Integer.parseInt( nodes[ i ] ) );
                    cur.right = right;
                    q.add( right );
                }
            }
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}