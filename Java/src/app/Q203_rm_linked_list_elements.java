package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Runtime: 1 ms, faster than 98.50% of Java online submissions for Remove Linked List Elements.
// Memory Usage: 38.2 MB, less than 100.00% of Java online submissions for Remove Linked List Elements.
class Q203_rm_linked_list_elements
{
    public ListNode removeElements(ListNode head, int val)
    {
        if( head == null ) return head;
        
        ListNode dummy = new ListNode( -1 );
        dummy.next = head;
        ListNode ptr = dummy.next, pre = dummy;
        while( ptr != null )
        {
            // deletion
            if( ptr.val == val )
                // if deletion, don't move the pre pointer
                pre.next = ptr.next;
            else
                pre = ptr;
            
            ptr = ptr.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}