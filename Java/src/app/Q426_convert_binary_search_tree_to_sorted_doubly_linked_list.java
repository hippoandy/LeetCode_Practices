package app;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Q426_convert_binary_search_tree_to_sorted_doubly_linked_list
{
    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root)
    {
        if( root == null ) return root;
        
        build( root );
        last.right = first;
        first.left = last;
        
        return first;
    }
    
    // inorder
    private void build( Node node )
    {
        if( node != null )
        {
            // left subtree
            build( node.left );
            
            // "last" use as ptr pointer!!
            if( last != null )
            {
                last.right = node;
                node.left = last;
            }
            else
                first = node;
            // ptr = ptr.next
            last = node;

            // right subtree
            build( node.right );
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}