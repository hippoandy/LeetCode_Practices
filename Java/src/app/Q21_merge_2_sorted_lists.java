package app;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q21_merge_2_sorted_lists
{
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    // {
    //     ListNode dummy = new ListNode( -1 );
        
    //     ListNode ptr = dummy;
    //     while( l1 != null && l2 != null )
    //     {
    //         if( l1.val <= l2.val )
    //         {
    //             ptr.next = l1;
    //             l1 = l1.next;
    //         }
    //         else
    //         {
    //             ptr.next = l2;
    //             l2 = l2.next;
    //         }
    //         ptr = ptr.next;
    //     }
    //     if( l1 != null ) appendList( ptr, l1 );
    //     if( l2 != null ) appendList( ptr, l2 );
        
    //     return dummy.next;
    // }
    
    // private void appendList( ListNode dest, ListNode src )
    // {
    //     while( src != null )
    //     {
    //         dest.next = src;
    //         dest = dest.next;
    //         src = src.next;
    //     }
    // }

    // logic improved
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode( -1 );
        
        ListNode ptr = dummy;
        while( l1 != null && l2 != null )
        {
            if( l1.val <= l2.val )
            {
                ptr.next = l1;
                l1 = l1.next;
            }
            else
            {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        ptr.next = (l1 == null) ? l2 : l1;
        
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}