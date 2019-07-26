package app;

public class Q208_implement_trie_prefix_tree
{
    class Trie
    {
        class TrieNode
        {
            private TrieNode[] links; // R links to node children
            private final int R = 26;  // 26 english lowercase alphabets
            private boolean isEnd;
            // constructor
            public TrieNode()
            {
                this.links = new TrieNode[ R ];
            }
            
            public boolean containsKey( char c )
            {
                return this.links[ c - 'a' ] != null;
            }
            
            public TrieNode get( char c )
            {
                return this.links[ c - 'a' ];
            }
            
            public void put( char c, TrieNode n )
            {
                this.links[ c - 'a' ] = n;
            }
            
            public void setEnd()
            {
                this.isEnd = true;
            }
            
            public boolean isEnd()
            {
                return this.isEnd;
            }
        }

        private TrieNode root;
        
        /** Initialize your data structure here. */
        public Trie()
        {
            root = new TrieNode();
        }
        
        /** Inserts a word into the trie. */
        // Time: O(n), Space: O(n)
        public void insert(String word)
        {
            TrieNode n = root;
            for( int i = 0; i < word.length(); i++ )
            {
                char cur = word.charAt( i );
                if( !n.containsKey( cur ) )
                    n.put( cur, new TrieNode() );
                // keep appending
                n = n.get( cur );
            }
            n.setEnd();
        }
        
        private TrieNode searchPrefix( String word )
        {
            TrieNode n = root;
            for( int i = 0; i < word.length(); i++ )
            {
                char cur = word.charAt( i );
                if( n.containsKey( cur ) )
                    // keep following the path
                    n = n.get( cur );
                else
                    return null;
            }
            return n;
        }
        
        /** Returns if the word is in the trie. */
        // Time: O(n), Space: O(1)
        public boolean search(String word)
        {
            TrieNode n = searchPrefix( word );
            // word is exists iff the word is in the trie and it is not a prefix of another word
            return n != null && n.isEnd();
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix)
        {
            TrieNode n = searchPrefix( prefix );
            return n != null;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}