// ref. https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList

package app;

import java.util.*;

class Q460_lfu_cache
{
    class LFUCache
    {
        int capacity, min;
        Map<Integer, Node> cache;
        Map<Integer, LinkedList> countMap;
        
        public LFUCache(int capacity)
        {
            this.capacity = capacity;
            this.min = 0;
            
            // record all the node <Key:Node>
            this.cache = new HashMap<Integer, Node>();
            // record the freq with a list of Node <Freq:List<Node>>
            this.countMap = new HashMap<Integer, LinkedList>();
        }
        
        public int get(int key)
        {
            // invalid query
            if( this.capacity == 0 || !this.cache.containsKey( key ) ) return -1;

            Node ret = cache.get( key );
            // update the node (freq and priority)
            update( ret );
            return ret.val;
        }
        
        public void put(int key, int value)
        {
            if( this.capacity == 0 ) return;
            
            Node ptr;
            if( cache.containsKey( key ) )
            {
                ptr = cache.get( key );
                ptr.val = value;
                // update the node (freq and priority)
                update( ptr );
            }
            // new node
            else
            {
                ptr = new Node( key, value, 1 );
                cache.put( key, ptr );
                if( this.cache.size() > this.capacity )
                {
                    LinkedList least = countMap.get( this.min );
                    this.cache.remove( least.popTail().key );
                }
                this.min = 1;
                
                /** put the node to the new freq-associated list **/
                putNodeToFreqList( ptr );
            }
        }
        
        private void update( Node n )
        {
            LinkedList ll = countMap.get( n.freq );
            ll.removeNode( n );
            // update the global minimum to get the least freq used node list
            if( n.freq == this.min && ll.size == 0 ) this.min++;
            // increase the freq
            n.freq += 1;

            /** put the node to the new freq-associated list **/
            putNodeToFreqList( n );
        }
        
        /** put the node to the new freq-associated list **/
        private void putNodeToFreqList( Node n )
        {
            LinkedList newll = countMap.getOrDefault( n.freq, new LinkedList() );
            // make it the most recent use
            newll.insertHead( n );
            // put back to the count map
            countMap.put( n.freq, newll );
        }
        
        private class LinkedList
        {
            Node head, tail;
            int size;
            
            public LinkedList()
            {
                // generate the dummy pointers
                this.head = new Node(); this.tail = new Node();
                head.next = tail;
                tail.prev = head;

                this.size = 0;
            }
            
            private void insertHead( Node n )
            {
                head.next.prev = n;
                n.next = head.next;
                n.prev = head;
                head.next = n;
                
                this.size++;
            }
            
            public void removeNode( Node rm )
            {
                rm.prev.next = rm.next;
                rm.next.prev = rm.prev;

                rm.prev = null; rm.next = null;

                this.size--;
            }
            
            // the least frequently used
            public Node popTail()
            {
                if( this.size > 0 )
                {
                    Node pop = tail.prev;
                    this.removeNode( pop );
                    return pop;
                }
                return null;
            }
        }
        
        // doubly node
        private class Node
        {
            int key, val, freq;
            // pointer
            Node prev, next;
            
            public Node() { this.prev = null; this.next = null; }
            
            public Node( int k, int v, int f )
            {
                this.key = k; this.val = v; this.freq = f;
                this.prev = null; this.next = null;
            }
        }
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}