// ref. https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/184156/Easy-Understand-Java-Recursive-solution-beat-100-with-Explanation

package app;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Q430_flatten_a_multilevel_doubly_linked_list
{
    Node pre = null;

    public Node flatten( Node cur )
    {
        if( cur == null ) return cur;
        
        if( pre != null )
        {
            pre.next = cur; 
            cur.prev = pre;
        }
        
        pre = cur;
        Node next = cur.next;
        
        flatten( cur.child );
        // disconnect the child
        cur.child = null;

        flatten( next );
        return cur;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    
        public Node() {}
    
        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
}