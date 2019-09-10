package app;

import java.util.*;

class Q642_design_search_autocomplete_system
{
    class AutocompleteSystem
    {
        // trie
        TrieNode root;
        // store search term
        String search;

        public AutocompleteSystem(String[] sentences, int[] times)
        {
            // build the trie
            int i = 0;
            this.root = new TrieNode();
            for( String str: sentences )
                insertTrie( this.root, str, times[ i++ ] );

            this.search = "";
        }
        
        public void insertTrie( TrieNode root, String str, int freq )
        {
            TrieNode cur = root;
            for( char c: str.toCharArray() )
            {
                if( cur.child[ c ] == null ) cur.child[ c ] = new TrieNode();
                cur = cur.child[ c ];
            }
            // increase the count as the search increase
            cur.setEnd( str, cur.freq + freq );
        }
        
        public List<String> input( char c )
        {
            List<String> candi = new ArrayList<String>();
            if( c == '#' )
            {
                insertTrie( root, this.search, 1 );
                // reset
                this.search = "";
            }
            else
            {
                this.search += c;

                // search candi
                List<Pair> found = searchCandi( this.root, this.search );
                Collections.sort( found, new Comparator<Pair>()
                {   @Override
                    public int compare( Pair a, Pair b )
                    {
                        if( a.val == b.val ) return a.term.compareTo( b.term );
                        return b.val - a.val;
                    }
                });
                for( int i = 0; i < Math.min( 3, found.size() ); i++ )
                    candi.add( found.get( i ).term );
            }
            return candi;
        }
        
        public List<Pair> searchCandi( TrieNode cur, String search )
        {
            List<Pair> candi = new ArrayList<Pair>();
            for( int i = 0; i < search.length(); i++ )
            {
                if( cur.child[ search.charAt( i ) ] == null ) return new ArrayList<Pair>();
                cur = cur.child[ search.charAt( i ) ];
            }
            // if found, traverse to search for other terms longer than current search
            traverse( search, cur, candi );
            return candi;
        }
        
        public void traverse( String search, TrieNode cur, List<Pair> candi )
        {
            if( cur.freq > 0 ) candi.add( new Pair( search, cur.freq ) );

            // search for potential longer terms
            for( char i = 'a'; i <= 'z'; i++ )
                if( cur.child[ i ] != null )
                    traverse( search + i, cur.child[ i ], candi );
            if( cur.child[ ' ' ] != null )
                traverse( search + ' ', cur.child[ ' ' ], candi );
        }
        
        private class Pair
        {
            String term;
            int val;
            public Pair( String term, int val )
            {
                this.term = term;
                this.val = val;
            }
        }
        
        private class TrieNode
        {
            TrieNode[] child;
            String term;
            boolean isEnd;
            int freq;

            public TrieNode()
            {
                // the size of the whole ascii table
                this.child = new TrieNode[ 256 ];
                this.term = "";
                this.isEnd = false;
                this.freq = 0;
            }
            
            public void setEnd( String term, int freq )
            {
                this.term = term;
                this.freq = freq;
                this.isEnd = true;
            }
        }
    }

    /**
     * Your AutocompleteSystem object will be instantiated and called as such:
     * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
     * List<String> param_1 = obj.input(c);
     */
}