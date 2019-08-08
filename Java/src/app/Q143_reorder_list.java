// ref. https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps

package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q143_reorder_list
{
    public void reorderList(ListNode head)
    {
        if( head == null ) return;
        
        // Find the middle of the list
        // ex: 1 -> 2 -> 3 -> 4 -> 5 -> 6, find 3
        ListNode slow = head, fast = head.next;
        while( fast != null && fast.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        // ex: 1 -> 2 -> 3 -> 4 -> 5 -> 6 => 1 -> 2 -> 3 -> 6 -> 5 -> 4
        ListNode h2 = reverse(slow.next);
        // seperate the list
        slow.next = null;
        
        ListNode h1 = head;
        // Link the two halves together
        while( h1 != null && h2 != null )
        {
            // store the original next position for both the two list
            ListNode tmp1 = h1.next;
            ListNode tmp2 = h2.next;

            // insert the head of list2 between node of list1
            h2.next = h1.next;
            h1.next = h2;
            h1 = tmp1;
            h2 = tmp2;
        }
    }
    
    private ListNode reverse( ListNode n )
    {
        ListNode prev = null;
        ListNode cur = n;
        while( cur != null )
        {
            // store the original next position
            ListNode tmp = cur.next;
            // cut the link
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}