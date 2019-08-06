package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q92_reverse_linked_list_2
{
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if( head == null ) return head;
        if( m > n ) throw null;
        
        ListNode pre = null;
        ListNode ptr = head;
        
        // move to the start point
        while( m > 1 )
        {
            pre = ptr;
            ptr = ptr.next;
            m--;
            n--;
        }
        
        // con will stores the start points that the list should be reversed
        // tail will point to the node that is the last node of ther reversed part
        ListNode con = pre, tail = ptr;
        
        ListNode tmp = null;
        while( n > 0 )
        {
            tmp = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = tmp;
            n--;
        }
        // after this loop, ptr will point to the node that is the head of the remaining parts
        // of the list that should not be reversed (idx > n)
        
        // corner case, start reversing at original head
        if( con != null ) con.next = pre;
        else
            head = pre;
        // connect the remaining part
        tail.next = ptr;
        
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}