package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q206_reverse_linked_list
{
    // recursive
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    // Memory Usage: 36.9 MB, less than 99.65% of Java online submissions for Reverse Linked List.
    public ListNode reverseList( ListNode cur )
    {
        if( cur == null || cur.next == null ) return cur;
        ListNode p = reverseList( cur.next );
        cur.next.next = cur;
        cur.next = null;
        return p;
    }

//     // iterative
//     // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
//     // Memory Usage: 37.3 MB, less than 99.41% of Java online submissions for Reverse Linked List.
//     public ListNode reverseList(ListNode head)
//     {
//         if( head == null ) return head;

//         ListNode pre = null;
//         ListNode ptr = head;
//         while( ptr != null )
//         {
//             ListNode tmp = ptr.next;
//             ptr.next = pre;
//             pre = ptr;
//             ptr = tmp;
//         }

//         return pre;
//     }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}