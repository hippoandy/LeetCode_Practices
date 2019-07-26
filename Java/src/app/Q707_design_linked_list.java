// ref. https://leetcode.com/problems/design-linked-list/discuss/213901/Simple-Java-solution

package app;

// Runtime: 53 ms, faster than 69.30% of Java online submissions for Design Linked List.
// Memory Usage: 45.4 MB, less than 88.19% of Java online submissions for Design Linked List.
public class Q707_design_linked_list
{
    class MyLinkedList
    {
        class Node
        {
            int val;
            Node next;
            public Node ( int val )
            {
                this.val = val;
            }
        }

        private Node head;
        private int size;

        /** Initialize your data structure here. */
        public MyLinkedList()
        {
            head = null;
            size = 0;
        }
        
        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index)
        {
            if( index < 0 || index >= size ) return -1;
            if( index == 0 ) return head.val;
            Node ptr = head;
            for (int i = 0; i < index; i++) ptr = ptr.next;
            return ptr.val;
        }
        
        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val)
        {
            Node prev = head;
            head = new Node( val );
            head.next = prev;
            size++;
        }
        
        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val)
        {
            Node node = new Node( val );
            size++;
            if( head == null ) head = node;
            else
            {
                Node ptr = head;
                while (ptr.next != null) ptr = ptr.next;
                ptr.next = node;
            }
        }
        
        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val)
        {
            if( index > size ) return;

            if( index <= 0 )         addAtHead( val );
            else if( index == size ) addAtTail( val );
            else
            {
                size++;
                Node ptr = head;
                for( int i = 0; i < index - 1; i++ ) ptr = ptr.next;
                Node n = new Node( val );
                n.next = ptr.next;
                ptr.next = n;
            }
        }
        
        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index)
        {
            if( index < 0 || index >= size ) return;
            size--;
            if( size == 0 )
            {
                head = head.next;
                return;
            }
            if( index == 0 )
            {
                head = head.next;
                return;
            }
            Node ptr = head;
            for (int i = 0; i < index - 1; i++) ptr = ptr.next;
            ptr.next = ptr.next.next;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */

    // class MyLinkedList
    // {
    //     private class Node
    //     {
    //         int val;
    //         Node next;
    //         public Node ( int val )
    //         {
    //             this.val = val;
    //             this.next = null;
    //         }
    //     }

    //     Node head;
    //     int size;
        
    //     /** Initialize your data structure here. */
    //     public MyLinkedList()
    //     {
    //         head = null;
    //         size = 0;
    //     }
        
    //     /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    //     public int get(int index)
    //     {
    //         if( index < 0 || index >= size ) return -1;
    //         if( head == null )               return -1;
            
    //         Node ptr = head;
    //         for( int i = 0 ; i <= index; i++ ) ptr = ptr.next;
    //         return ptr.val;
    //     }
        
    //     /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    //     public void addAtHead(int val)
    //     {
    //         Node n = new Node( val );
    //         n.next = head;
    //         head = n;

    //         size++;
    //     }
        
    //     /** Append a node of value val to the last element of the linked list. */
    //     public void addAtTail(int val)
    //     {
    //         Node n = new Node( val );
    //         Node ptr = head;
    //         if( ptr == null )   head = n;
    //         else
    //         {
    //             while( ptr.next != null ) ptr = ptr.next;
    //             ptr.next = n;
    //         }

    //         size++;
    //     }
        
    //     /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    //     public void addAtIndex(int index, int val)
    //     {
    //         if( index < 0 || index > size ) return;

    //         // add at head
    //         if( index == 0 ) addAtHead( val );
    //         else
    //         {
    //             Node ptr = head;
    //             for( int i = 0; i < index - 1; i++ ) ptr = ptr.next;
    //             Node n = new Node( val );
    //             n.next = ptr.next;
    //             ptr.next = n;
    //             size++;
    //         }
    //     }
        
    //     /** Delete the index-th node in the linked list, if the index is valid. */
    //     public void deleteAtIndex(int index)
    //     {
    //         if( index < 0 || index >= size ) return;
    //         if( head == null )               return;
            
    //         Node ptr = head;
    //         for( int i = 0; i < index - 1; i++ )
    //                 ptr = ptr.next;
    //             ptr.next = ptr.next.next;

    //         size--;
    //     }
    // }

    // /**
    //  * Your MyLinkedList object will be instantiated and called as such:
    //  * MyLinkedList obj = new MyLinkedList();
    //  * int param_1 = obj.get(index);
    //  * obj.addAtHead(val);
    //  * obj.addAtTail(val);
    //  * obj.addAtIndex(index,val);
    //  * obj.deleteAtIndex(index);
    //  */
}