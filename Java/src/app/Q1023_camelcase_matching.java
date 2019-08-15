// ref. https://leetcode.com/problems/camelcase-matching/discuss/270002/Python-Trie-Solution

package app;

import java.util.*;

class Q1023_camelcase_matching
{
    public List<Boolean> camelMatch(String[] queries, String pattern)
    {
        // build the trie
        TrieNode root = new TrieNode();
        for( String q: queries )
        {
            TrieNode cur = root;
            for( char c: q.toCharArray() )
            {
                if( !cur.child.containsKey( c ) ) cur.child.put( c, new TrieNode() );
                cur = cur.child.get( c );
            }
            cur.isEnd = true;
        }
        
        Map<String, Boolean> table = new HashMap<String, Boolean>();
        find( root, pattern, 0, "", table );

        // get the result
        List<Boolean> ans = new ArrayList<Boolean>();
        for( String q: queries ) ans.add( table.getOrDefault( q, false ) );
        return ans;
    }
    
    private void find( TrieNode cur, String pattern, int idx, String tmp, Map<String, Boolean> table )
    {
        if( idx >= pattern.length() )
        {
            if( cur.isEnd ) table.put( tmp, true );
            for( char c: cur.child.keySet() )
                // only append lower case char, if there is still upper case existing,
                // the tmp string will never have that char
                if( c >= 'a' && c <= 'z' )
                    find( cur.child.get( c ), pattern, idx, tmp+c, table );
        }
        else
            for( char c: cur.child.keySet() )
            {
                if( c == pattern.charAt( idx ) )
                    find( cur.child.get( c ), pattern, idx+1, tmp+c, table );
                else if( c >= 'a' && c <= 'z' )
                    find( cur.child.get( c ), pattern, idx, tmp+c, table );
            }
    }
    
    private class TrieNode
    {
        Map<Character, TrieNode> child;
        boolean isEnd;
        
        public TrieNode()
        {
            this.child = new HashMap<Character, TrieNode>();
            this.isEnd = false;
        }
    }
}