package app;

import java.util.*;

class Q146_lru_cache
{
    class LRUCache
    {
        private Map<Integer, DoubleLinkNode> cache;
        private int capacity = 0;
        private int size = 0;
        private DoubleLinkNode head, tail;

        // always add the new node right after head.
        private void addNodeNextToHead( DoubleLinkNode n )
        {
            n.prev = head;
            n.next = head.next;
            
            head.next.prev = n;
            head.next = n;
        }
        
        // remove an existing node from the list
        private void removeNode( DoubleLinkNode n )
        {
            DoubleLinkNode prev = n.prev, next = n.next;
            prev.next = next;
            next.prev = prev;
        }
        
        // move a certain node next to head
        private void moveNodeNextToHead( DoubleLinkNode n )
        {
            removeNode( n );
            addNodeNextToHead( n );
        }
        
        // pop the current tail
        private DoubleLinkNode popTail()
        {
            DoubleLinkNode cur = tail.prev;
            removeNode( cur );
            return cur;
        }
        
        public LRUCache(int capacity)
        {
            this.size = 0;
            this.capacity = capacity;
            this.cache = new HashMap<Integer, DoubleLinkNode>();
            // 2 dummy pointer
            this.head = new DoubleLinkNode();
            this.tail = new DoubleLinkNode();
            // link head and tail together
            this.head.next = this.tail;
            this.tail.prev = head;
        }
        
        public void put(int key, int value)
        {
            if( !cache.containsKey( key ) )
            {
                DoubleLinkNode n = new DoubleLinkNode( key, value );
                cache.put( key, n );
                // always add the new element next to head
                addNodeNextToHead( n );
                size++;
                // if it's oversize
                if( size > capacity )
                {
                    // pop the tail
                    DoubleLinkNode tail = popTail();
                    cache.remove( tail.key );
                    size--;
                }
            }
            else
            // update the value
            {
                DoubleLinkNode n = cache.get( key );
                n.val = value;
                // increase the priority
                moveNodeNextToHead( n );
            }
        }
        
        public int get(int key)
        {
            if( !cache.containsKey( key ) ) return -1;
            DoubleLinkNode n = cache.get( key );
            // increase the priority
            moveNodeNextToHead( n );
            return n.val;
        }
        
        class DoubleLinkNode
        {
            int key;
            int val;
            DoubleLinkNode next;
            DoubleLinkNode prev;
            
            public DoubleLinkNode()
            {
                this.next = null;
                this.prev = null;
            }
            
            public DoubleLinkNode( int key, int val )
            {
                this.key = key;
                this.val = val;
                this.next = null;
                this.prev = null;
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}