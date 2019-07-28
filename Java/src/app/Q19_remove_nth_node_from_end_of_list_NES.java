package app;

class Q19_remove_nth_node_from_end_of_list_NES
{
    // logic improved, one-pass
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
    // Memory Usage: 35 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        // the dummy node is to deal with the corner case more easier
        ListNode dummy = new ListNode( 0 );
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        for( int i = 0; i <= n; i++ ) fast = fast.next;
        while( fast != null )
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }

    // // two-pass
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
    // Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
    // public ListNode removeNthFromEnd(ListNode head, int n)
    // {
    //     // the dummy node is to deal with the corner case more easier
    //     ListNode dummy = new ListNode( 0 );
    //     dummy.next = head;
    //     int len = 0;
    //     // first pass, to find the len of the list
    //     // for example, case 1 -> 2 -> 3 -> 4 -> 5
    //     ListNode ptr = head;
    //     while( ptr != null )
    //     {
    //         ptr = ptr.next;
    //         len++;
    //     }
    //     // len = 5
    //     // n = 2
    //     len -= n; // node to delete = 3
    //     ptr = dummy;
    //     // second pass
    //     while( len > 0 )
    //     {
    //         len--;
    //         ptr = ptr.next;
    //     }
    //     // relink
    //     // remember we start from dummy node!!
    //     ptr.next = ptr.next.next;
        
    //     return dummy.next;
    // }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}