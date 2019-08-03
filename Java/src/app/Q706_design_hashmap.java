// ref. https://leetcode.com/problems/design-hashmap/discuss/185347/Hash-with-Chaining-Python

package app;

class Q706_design_hashmap
{
    class MyHashMap
    {
        Node[] bucket;

        /** Initialize your data structure here. */
        public MyHashMap()
        {
            this.bucket = new Node[ 10000 ];
        }
        
        /** value will always be non-negative. */
        public void put( int key, int val )
        {
            int idx = computeIdx( key );
            if( this.bucket[ idx ] == null )
                this.bucket[ idx ] = new Node( key, val );
            else
            {
                Node cur = this.bucket[ idx ];
                while( true )
                {
                    if( cur.key == key )
                    {
                        cur.key = key;
                        cur.val = val;  // update
                        return;
                    }
                    if( cur.next == null ) break;
                    cur = cur.next;
                }
                // add new node while collision
                cur.next = new Node( key, val );
            }
        }
        
        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get( int key )
        {
            int idx = computeIdx( key );
            Node cur = this.bucket[ idx ];
            while( cur != null )
            {
                if( cur.key == key ) return cur.val;
                cur = cur.next;
            }
            return -1;
        }
        
        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove( int key )
        {
            int idx = computeIdx( key );
            Node cur = bucket[ idx ];
            // no such node
            if( cur == null ) return;
            if( cur.key == key )
            {
                bucket[ idx ] = cur.next;
                return;
            }
            else
            {
                Node pre = bucket[ idx ];
                cur = cur.next;
                while( cur != null )
                {
                    if( cur.key == key )
                    {
                        pre.next = cur.next;
                        break;
                    }
                    cur = cur.next;
                    pre = pre.next;
                }
            }
        }
        
        private int computeIdx( int k )
        {
            return Integer.hashCode( k ) % bucket.length;
        }
        
        class Node
        {
            int key;
            int val;
            Node next;

            public Node( int key, int val )
            {
                this.key = key;
                this.val = val;
                this.next = null;
            }
        }
    }
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
}