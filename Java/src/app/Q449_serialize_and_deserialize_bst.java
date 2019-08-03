// ref. https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/93175/Java-PreOrder-%2B-Queue-solution

package app;

class Q449_serialize_and_deserialize_bst
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
    public class Codec
    {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root)
        {
            StringBuilder sb = new StringBuilder();
            preorder( root, sb );
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data)
        {
            if( data.length() == 0 ) return null;
            
            String[] parts = data.split( "," );
            TreeNode root = new TreeNode( Integer.parseInt( parts[ 0 ] ) );
            for( int i = 1; i < parts.length; i++ )
                bstInsertion( root, new TreeNode( Integer.parseInt( parts[ i ] ) ) );
            return root;
        }
        
        private void preorder( TreeNode cur, StringBuilder sb )
        {
            if( cur == null ) return;
            
            sb.append( cur.val + "," );
            preorder( cur.left, sb );
            preorder( cur.right, sb );
        }
        
        private void bstInsertion( TreeNode root, TreeNode n )
        {
            TreeNode cur = root, parent = null;
            while( cur != null )
            {
                parent = cur;
                cur = (cur.val > n.val) ? cur.left : cur.right;
            }
            
            if( parent.val < n.val )
                parent.right = n;
            else
                parent.left = n;
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
    }
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}