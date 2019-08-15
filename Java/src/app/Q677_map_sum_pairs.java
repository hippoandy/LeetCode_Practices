package app;

// Runtime: 46 ms, faster than 98.76% of Java online submissions for Map Sum Pairs.
// Memory Usage: 36 MB, less than 100.00% of Java online submissions for Map Sum Pairs.
class Q677_map_sum_pairs
{
    class MapSum
    {
        TrieNode root;

        /** Initialize your data structure here. */
        public MapSum()
        {
            this.root = new TrieNode();
        }
        
        public void insert(String key, int val)
        {
            TrieNode cur = this.root;
            for( int i = 0; i < key.length(); i++ )
            {
                int idx = key.charAt( i ) - 'a';
                if( cur.child[ idx ] == null ) cur.child[ idx ] = new TrieNode();
                cur = cur.child[ idx ];
            }
            cur.isEnd = true;
            cur.weight = val;
        }

        public int sum(String prefix)
        {
            TrieNode cur = this.root;
            for( char c: prefix.toCharArray() )
            {
                if( cur.child[ c - 'a' ] == null ) return 0;
                cur = cur.child[ c - 'a' ];
            }
            return helper( cur );
        }
        
        private int helper( TrieNode cur )
        {
            int sum = 0;
            for( int i = 'a'; i < 'z'; i++ )
                if( cur.child[ i - 'a' ] != null )
                    sum += helper( cur.child[ i - 'a' ] );
            return (cur.isEnd) ? sum + cur.weight : sum;
        }
        
        private class TrieNode
        {
            TrieNode[] child;
            int weight;
            boolean isEnd;
            
            public TrieNode()
            {
                this.child = new TrieNode[ 26 ];
                this.weight = -1;
                this.isEnd = false;
            }
        }
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
}