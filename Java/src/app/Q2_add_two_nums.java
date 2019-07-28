package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q2_add_two_nums {
    // logic improved 2
    // Runtime: 2 ms, faster than 84.68% of Java online submissions for Add Two Numbers.
    // Memory Usage: 44.5 MB, less than 85.58% of Java online submissions for Add Two Numbers.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode( -1 );
        ListNode p = l1, q = l2, cur = dummy;
        int carry = 0;
        while( p != null || q != null )
        {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;

            cur.next = new ListNode( sum % 10 );
            cur = cur.next;

            if( p != null ) p = p.next;
            if( q != null ) q = q.next;
        }
        if( carry != 0 )
            cur.next = new ListNode( carry );
        return dummy.next;
    }
    
//     // logic improved 1
//     // Runtime: 2 ms, faster than 84.68% of Java online submissions for Add Two Numbers.
//     // Memory Usage: 44.6 MB, less than 85.25% of Java online submissions for Add Two Numbers.
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2)
//     {
//         ListNode head = null;
//         ListNode p = l1, q = l2, cur = head;
//         int carry = 0;
//         while( p != null || q != null )
//         {
//             int x = (p != null) ? p.val : 0;
//             int y = (q != null) ? q.val : 0;
//             int sum = carry + x + y;
//             carry = sum / 10;
            
//             if( head == null )
//             {
//                 head = new ListNode( sum % 10 );
//                 cur = head;
//             }
//             else
//             {
//                 cur.next = new ListNode( sum % 10 );
//                 cur = cur.next;
//             }
//             if( p != null ) p = p.next;
//             if( q != null ) q = q.next;
//         }
//         if( carry != 0 )
//             cur.next = new ListNode( carry );
//         return head;
//     }

//     // Runtime: 2 ms, faster than 84.68% of Java online submissions for Add Two Numbers.
//     // Memory Usage: 45.1 MB, less than 82.91% of Java online submissions for Add Two Numbers.
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2)
//     {
//         ListNode head = null;
//         int carry = 0, val = 0;
//         ListNode ptr1 = l1, ptr2 = l2, ptr3 = null;
//         while( true )
//         {
//             if( ptr1 != null && ptr2 != null )
//             {
//                 val = (ptr1.val + ptr2.val + carry);
//                 ptr1 = ptr1.next;
//                 ptr2 = ptr2.next;
//             }
//             else if( ptr1 != null && ptr2 == null )
//             {
//                 val = (ptr1.val + carry);
//                 ptr1 = ptr1.next;
//             }
//             else if( ptr1 == null && ptr2 != null )
//             {
//                 val = (ptr2.val + carry);
//                 ptr2 = ptr2.next;
//             }
//             else
//                 break;

//             carry = val / 10;
//             ListNode n = new ListNode( val % 10 );
//             if( head == null )
//             {
//                 head = n;
//                 ptr3 = n;
//             }
//             else
//             {
//                 ptr3.next = new ListNode( val % 10 );
//                 ptr3 = ptr3.next;
//             }
//         }
//         // check the carry!
//         if( carry != 0 )
//             ptr3.next = new ListNode( carry );
//         return head;
//     }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}