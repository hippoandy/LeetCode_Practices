// ref. https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution

package app;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Q117_populating_next_right_pointers_in_each_node_2
{
    public Node connect(Node root)
    {
        if( root == null ) return null;
        
        Node head = null; // head of the next level
        Node ptr = null;  // pointer to traverse the current level
        Node cur = root;  // current node
        
        while( cur != null )
        {
            while( cur != null )
            {
                if( cur.left != null )
                {
                    // see the children
                    if( ptr == null ) head = cur.left;
                    else
                        ptr.next = cur.left;
                    ptr = cur.left;
                }
                
                if( cur.right != null )
                {
                    if( ptr == null ) head = cur.right;
                    else
                        ptr.next = cur.right;
                    ptr = cur.right;
                }
                // move to sibling
                cur = cur.next;
            }
            
            // move to next level;
            cur = head;
            ptr = null;
            head = null;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
    
        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}