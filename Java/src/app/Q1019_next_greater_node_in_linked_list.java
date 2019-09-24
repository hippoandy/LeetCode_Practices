// ref. https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC%2B%2BPython-Next-Greater-Element

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
class Q1019_next_greater_node_in_linked_list
{
    public int[] nextLargerNodes(ListNode head)
    {
        // 1. transform to an array list
        List<Integer> arr = new ArrayList<Integer>();
        for( ListNode node = head; node != null; node = node.next ) arr.add( node.val );
        
        // next greater element
        // stack is to record the index
        int[] res = new int[ arr.size() ];
        Stack<Integer> stack = new Stack<Integer>();
        for( int i = 0; i < arr.size(); i++ )
        {
            while( !stack.isEmpty() && arr.get( i ) > arr.get( stack.peek() ) )
                res[ stack.pop() ] = arr.get( i );
            stack.push( i );
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}