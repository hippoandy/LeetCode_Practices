// ref. https://leetcode.com/problems/implement-magic-dictionary/discuss/107453/Easiest-JAVA-with-Trie-no-need-to-count-the-number-of-changes   

package app;

// Runtime: 49 ms, faster than 27.91% of Java online submissions for Implement Magic Dictionary.
// Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Implement Magic Dictionary.
class Q676_implement_magic_dict
{
    class MagicDictionary
    {
        TrieNode root;

        /** Initialize your data structure here. */
        public MagicDictionary()
        {
            this.root = new TrieNode();
        }
        
        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict)
        {
            for( String d: dict )
            {
                TrieNode cur = this.root;
                for( int i = 0; i < d.length(); i++ )
                {
                    int idx = d.charAt( i ) - 'a';
                    if( cur.child[ idx ] == null ) cur.child[ idx ] = new TrieNode();
                    cur = cur.child[ idx ];
                }
                cur.isEnd = true;
            }
        }
        
        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search( String word )
        {
            char[] arr = word.toCharArray();
            for( int i = 0; i < word.length(); i++ )
            {
                for( char c = 'a'; c <= 'z'; c++ )
                {
                    if( arr[ i ] == c) continue;
                    // change 1 char
                    char org = arr[ i ];
                    arr[ i ] = c;
                    if( helper( new String( arr ) ) ) return true;
                    // restore
                    arr[ i ] = org;
                }
            }
            return false;
        }
        public boolean helper( String w )
        {
            TrieNode cur = this.root;
            for( char c : w.toCharArray() )
            {
                if( cur.child[c - 'a' ] == null ) return false;
                cur = cur.child[ c - 'a' ];
            }
            return cur.isEnd;
        }
        
        private class TrieNode
        {
            TrieNode[] child;
            boolean isEnd;
            
            public TrieNode()
            {
                this.child = new TrieNode[ 26 ];
                this.isEnd = false;
            }
        }
    }

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dict);
     * boolean param_2 = obj.search(word);
     */
}