package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q83_rm_dups_from_sorted_list
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if( head == null ) return head;
        
        ListNode cur = head;
        while( cur != null && cur.next != null )
        {
            if( cur.val == cur.next.val )
                // remove the node
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}