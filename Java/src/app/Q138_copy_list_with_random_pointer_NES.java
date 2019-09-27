// ref. https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)

package app;

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

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
// Memory Usage: 32.8 MB, less than 99.18% of Java online submissions for Copy List with Random Pointer.
class Q138_copy_list_with_random_pointer_NES
{
    // improved space complexity
    public Node copyRandomList(Node head)
    {
        if( head == null ) return null;
        
        /** 1. build the list A --> A' --> B --> B' --> C --> C' --> D --> D' **/
        Node ptr = head, next;
        while( ptr != null )
        {
            // keep the original next
            next = ptr.next;
            // perform copy
            ptr.next = new Node( ptr.val );
            // append the node to the list
            ptr.next.next = next;
            
            ptr = next;
        }
        
        /** 2. assign the random ptr **/
        ptr = head;
        while( ptr != null )
        {
            if( ptr.random != null )
                // ptr.random.next: since we are having dup nodes
                ptr.next.random = ptr.random.next;
            ptr = ptr.next.next;
        }
        
        /** 3. seperate the list **/
        Node copy = head.next;
        // traversing pointers
        Node ptr1 = head, ptr2 = copy;
        while( ptr2.next != null )
        {
            ptr1.next = ptr1.next.next;
            ptr2.next = ptr2.next.next;

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // cut the list
        ptr1.next = null;
        
        return copy;
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