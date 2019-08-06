package app;

import java.util.*;

// Runtime: 8 ms, faster than 87.44% of Java online submissions for Serialize and Deserialize N-ary Tree.
// Memory Usage: 52.3 MB, less than 70.59% of Java online submissions for Serialize and Deserialize N-ary Tree.
class Q428_serialize_and_deserialize_n_ary_tree
{
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    */
    class Codec
    {
        // Encodes a tree to a single string.
        public String serialize(Node root)
        {
            if( root == null ) return " ";
            StringBuilder sb = new StringBuilder();
            dfs( sb, root );
            return sb.toString();
        }
        
        private void dfs( StringBuilder sb, Node cur )
        {
            sb.append( cur.val + " " );
            if( cur.children.size() != 0 )
            {
                sb.append( "[" );
                for( int i = 0; i < cur.children.size(); i++ )
                    dfs( sb, cur.children.get( i ) );
                sb.append( "]" );
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data)
        {
            Stack<Node> stack = new Stack<Node>();
            Node root = null, ptr = null;
            
            int val = 0;
            for( int i = 0; i < data.length(); i++ )
            {
                char c = data.charAt( i );
                if( Character.isDigit( c ) )
                {
                    int j = i;
                    while( j < data.length() && Character.isDigit( data.charAt( j ) ) )
                    {
                        val = val * 10 + (int) (data.charAt( j ) - '0');
                        j++;
                    }

                    Node n = new Node( val, new ArrayList<Node>() );
                    ptr = n;
                    if( root == null ) root = n;
                    if( !stack.isEmpty() )
                        stack.peek().children.add( n );
                    
                    // reset
                    val = 0;
                    i = j;
                }
                else if( c == '[' )      
                    stack.push( ptr );
                else if( c == ']' )
                    stack.pop();
            }
            return root;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}