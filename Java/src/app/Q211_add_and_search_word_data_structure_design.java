// ref. https://leetcode.com/problems/add-and-search-word-data-structure-design/discuss/59554/My-simple-and-clean-Java-code

package app;

public class Q211_add_and_search_word_data_structure_design
{
    class WordDictionary
    {
        class TrieNode
        {
            private final int R = 26;
            private TrieNode[] links;
            private boolean isEnd;
            
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
        public WordDictionary()
        {
            this.root = new TrieNode();
        }
        
        /** Adds a word into the data structure. */
        public void addWord(String word)
        {
            TrieNode n = root;
            for( int i = 0; i < word.length(); i++ )
            {
                char c = word.charAt( i );
                if( !n.containsKey( c ) )
                    n.put( c, new TrieNode() );
                n = n.get( c );
            }
            n.setEnd();
        }

        private boolean searchPrefix( char[] chs, int k, TrieNode node )
        {
            if( k == chs.length ) return node.isEnd();   
            if( chs[ k ] != '.' )
            {
                TrieNode next = node.links[ chs[ k ] - 'a' ];
                return next != null && searchPrefix( chs, k+1, next );
            }
            else
            {
                // try all possibilities
                for( int i = 0; i < node.links.length; i++ )
                {
                    if( node.links[ i ] != null )
                    {
                        if( searchPrefix( chs, k + 1, node.links[ i ] ) )
                            return true;
                    }
                }
            }
            return false;
        }
        
        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word)
        {
            return searchPrefix( word.toCharArray(), 0, this.root );
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}