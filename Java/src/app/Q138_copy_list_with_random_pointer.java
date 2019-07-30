// ref. https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43488/Java-O(n)-solution

package app;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

// Runtime: 1 ms, faster than 73.42% of Java online submissions for Copy List with Random Pointer.
// Memory Usage: 35.2 MB, less than 39.25% of Java online submissions for Copy List with Random Pointer.
class Q138_copy_list_with_random_pointer
{
    public Node copyRandomList(Node head)
    {
        if( head == null ) return null;

        // Node A & A'
        Map<Node, Node> map = new HashMap<Node, Node>();
        // walk through the list and create (A, A') pair
        Node ptr = head;
        while( ptr != null )
        {
            map.put( ptr, new Node( ptr.val ) );
            ptr = ptr.next;
        }
        
        // walk through the list for the second time to assign value to n'
        ptr = head;
        while( ptr != null )
        {
            // get the A' node and assign value
            map.get( ptr ).next = map.get( ptr.next );
            map.get( ptr ).random = map.get( ptr.random );
            ptr = ptr.next;
        }
        
        return map.get( head );
    }

    class Node {
        public int val;
        public Node next;
        public Node random;
    
        public Node( int _val ) {
            val = _val;
            next = null;
            random = null;
        }
    
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}