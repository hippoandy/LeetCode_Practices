package app;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Runtime: 1 ms, faster than 10.38% of Java online submissions for Remove Nth Node From End of List.
// Memory Usage: 36 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
class Q19_remove_nth_node_from_end_of_list_MAP
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if( head == null || n <= 0 ) return head;

        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        ListNode ptr = head;
        int idx = 1, len = 0;
        while( ptr != null )
        {
            map.put( idx++, ptr );
            ptr = ptr.next;
            len++;
        }
        
        int toDel = len - n + 1;
        // delete head
        if( toDel == 1 )
            return head.next;
        // delete tail
        if( toDel == len )
        {
            map.get( toDel - 1 ).next = null;
            return head;
        }
        else
        {
            map.get( toDel - 1 ).next = map.get( toDel + 1 );
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}