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
class Q23_merge_k_sorted_lists
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        if( lists == null || lists.length == 0 ) return null;

        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>( (a, b) -> a.val - b.val );
        
        for( ListNode n: lists )
            if( n != null )
                q.offer( n );
        
        // form the list
        // for corner case: empty list
        ListNode dummy = new ListNode( -1 );
        ListNode ptr = dummy;
        while( !q.isEmpty() )
        {
            ptr.next = q.remove();
            ptr = ptr.next;
            // the priority queue will help kee the item sorted
            // put the remaining of the list back to the priority queue
            if( ptr.next != null ) q.offer( ptr.next );
        }
        return dummy.next;
    }

    // public ListNode mergeKLists(ListNode[] lists)
    // {
    //     if( lists == null || lists.length == 0 ) return null;

    //     PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(
    //         new Comparator<ListNode>()
    //         {   @Override
    //             public int compare( ListNode n1, ListNode n2 )
    //             {
    //                 if( n1.val < n2.val ) return -1;
    //                 else if( n1.val == n2.val ) return 0;
    //                 else return 1;
    //             }
    //         }
    //     );
        
    //     for( ListNode n: lists )
    //         if( n != null )
    //             q.offer( n );
        
    //     // form the list
    //     // for corner case: empty list
    //     ListNode dummy = new ListNode( -1 );
    //     ListNode ptr = dummy;
    //     while( !q.isEmpty() )
    //     {
    //         ptr.next = q.remove();
    //         ptr = ptr.next;
    //         // the priority queue will help kee the item sorted
    //         if( ptr.next != null ) q.offer( ptr.next );
    //     }
        
    //     return dummy.next;
    // }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}