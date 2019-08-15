// ref. https://stackoverflow.com/questions/1509391/how-to-get-the-one-entry-from-hashmap-without-iterating

package app;

import java.util.*;

// Runtime: 4 ms, faster than 7.36% of Java online submissions for Longest Common Prefix.
// Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Longest Common Prefix.
class Q14_longest_common_prefix_TRIE
{
    public String longestCommonPrefix(String[] strs)
    {
        // build the trie
        TrieNode root = new TrieNode();
        // record the min len of strings
        int min_len = Integer.MAX_VALUE;
        for( String s: strs )
        {
            // if there is an empty string, there is no way to have common prefix!
            if( s.equals( "" ) ) return "";
            min_len = (s.length() < min_len) ? s.length() : min_len;

            TrieNode cur = root;
            for( char c: s.toCharArray() )
            {
                if( !cur.child.containsKey( c ) ) cur.put( c, new TrieNode () );
                cur = cur.child.get( c );
            }
            cur.isEnd = true;
        }
        
        String prefix = "";
        TrieNode cur = root;
        while( cur != null && cur.getSize() == 1 && min_len > 0 )
        {
            Map.Entry<Character, TrieNode> entry = cur.child.entrySet().iterator().next();
            cur = entry.getValue();
            prefix += entry.getKey();
            // consider case ["aa","a"], if there is no boundary, the answer of our logic will be "aa"
            min_len--;
        }
        return prefix;
    }
    
    private class TrieNode
    {
        Map<Character, TrieNode> child;
        int size;
        boolean isEnd;

        public TrieNode()
        {
            this.child = new HashMap<Character, TrieNode>();
            this.isEnd = false;
            this.size = 0;
        }
        
        public void put( char c, TrieNode n )
        {
            this.child.put( c, n );
            this.size++;
        }
        
        public int getSize()
        {
            return this.size;
        }
    }
}