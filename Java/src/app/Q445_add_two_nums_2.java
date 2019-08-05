// ref. https://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stack

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
class Q445_add_two_nums_2
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        // push into stack
        while( l1 != null )
        {
            s1.push( l1.val );
            l1 = l1.next;
        }
        while( l2 != null )
        {
            s2.push( l2.val );
            l2 = l2.next;
        }
        
        // the sum will hold the carry for the next stage
        int sum = 0;
        // most significant bit comes first!!
        ListNode list = new ListNode( 0 );
        while( !s1.isEmpty() || !s2.isEmpty() )
        {
            if( !s1.isEmpty() ) sum += s1.pop();
            if( !s2.isEmpty() ) sum += s2.pop();

            list.val = sum % 10;

            ListNode n = new ListNode( sum/10 );
            n.next = list;
            list = n;
            // the carry for next stage
            sum /= 10;
        }
        // note that there will be a dummy node before ptr list
        // if the head doesn't have the carry, it's a dummy node
        // it not a dummy node for case like [9, 9] + [1]
        return (list.val == 0) ? list.next : list;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}