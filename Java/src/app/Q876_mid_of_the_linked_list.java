package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q876_mid_of_the_linked_list
{
    public ListNode middleNode(ListNode head)
    {
        if( head == null ) return null;

        ListNode slow = head, fast = head;
        
        while( fast != null && fast.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}