package app;

import java.util.*;

class Q737_sentence_similarity_2
{
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        // base case
        if( words1.length != words2.length ) return false;
        if( pairs.size() == 0 ) return true;
        
        Map<String, Integer> wordToID = new HashMap<String, Integer>();
        
        DSU dsu = new DSU( 2 * pairs.size() );
        
        int idx = 0;
        for( List<String> p: pairs )
        {
            for( String w: p )
                if( !wordToID.containsKey( w ) ) wordToID.put( w, idx++ );
            dsu.unify( wordToID.get( p.get( 0 ) ), wordToID.get( p.get( 1 ) ) );
        }
        
        for( int i = 0; i < words1.length; i++ )
        {
            String w1 = words1[ i ], w2 = words2[ i ];
            if( w1.equals( w2 ) ) continue;
            // some of the word in the sentence may not exist in the pair list!!
            if( !wordToID.containsKey( w1 ) || !wordToID.containsKey( w2 ) ) return false;
            if( !dsu.equivalent( wordToID.get( w1 ), wordToID.get( w2 ) ) ) return false;
        }
        return true;
    }
    
    private class DSU
    {
        int[] parent;
        
        public DSU( int n )
        {
            this.parent = new int[ n * 2 ];
            for( int i = 0; i < this.parent.length; i++ )
                this.parent[ i ] = i;
        }
        
        public boolean equivalent( int x, int y )
        {
            return find( x ) == find( y );
        }
        
        public int find( int x )
        {
            if( x != this.parent[ x ] )
            {
                this.parent[ x ] = find( this.parent[ x ] );
            }
            return this.parent[ x ];
        }
        
        public void unify( int x, int y )
        {    
            this.parent[ find( x ) ] = find( y );
        }
    }
}