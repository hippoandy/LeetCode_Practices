// ref. https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11046/My-simple-JAVA-solution-for-share

package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q24_swap_nodes_in_pairs
{
    public ListNode swapPairs(ListNode head)
    {
        if( head == null ) return head;
        
        ListNode dummy = new ListNode( -1 );
        dummy.next = head;
        
        ListNode ptr = dummy;
        while( ptr.next != null && ptr.next.next != null )
        {
            ListNode first = ptr.next;
            ListNode second = ptr.next.next;
            first.next = second.next;
            ptr.next = second;
            ptr.next.next = first;
            
            // move to next stage
            ptr = ptr.next.next;
        }
        
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}