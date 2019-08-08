package app;

import java.util.*;

class Q734_sentence_similarity
{
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs)
    {
        if( words1.length != words2.length ) return false;
        int n = words1.length;
        
        Set<String> pairset = new HashSet<String>();
        for( List<String> p: pairs )
            pairset.add( p.get( 0 ) + "|" + p.get( 1 ) );
        
        for( int i = 0; i < n; i++ )
            if( !words1[ i ].equals( words2[ i ] ) &&
                !pairset.contains( words1[ i ] + "|" + words2[ i ] ) &&
                !pairset.contains( words2[ i ] + "|" + words1[ i ] )
              )
                return false;
        return true;
    }
}