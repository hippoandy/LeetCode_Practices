// ref. https://leetcode.com/problems/sort-list/discuss/46714/Java-merge-sort-solution

package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q148_sort_list
{
    public ListNode sortList(ListNode head)
    {
        if( head == null || head.next == null ) return head;
        
        // 1. divid the list into 2 lists
        ListNode slow = head, fast = head, mid = null;
        while( fast != null && fast.next != null )
        {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut the list
        mid.next = null;
        
        // 2. sort each half of the list
        ListNode left = sortList( head );
        ListNode right = sortList( slow );
        
        // 3. merge the 2 sorted half
        return merge( left, right );
    }
    
    private ListNode merge( ListNode l, ListNode r )
    {
        ListNode dummy = new ListNode( 0 );
        ListNode ptr = dummy;

        // sort
        while( l != null && r != null )
        {
            if( r.val > l.val )
            {
                ptr.next = l;
                l = l.next;
            }
            else
            {
                ptr.next = r;
                r = r.next;
            }
            ptr = ptr.next;
        }
        // check remainings if the 2 lists are not in the same size
        if( l != null ) ptr.next = l;
        if( r != null ) ptr.next = r;
        
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}