package app;

import java.util.*;

class Q1181_before_and_after_puzzle
{
    public List<String> beforeAndAfterPuzzles(String[] phrases)
    {
        // heading word and index mapping
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        // build the record
        int i = 0;
        for( String line: phrases )
        {
            // splite string into 2 parts {1st word}:{remaining}
            String first = line.split( "\\s", 2 )[ 0 ];

            if( !map.containsKey( first) ) map.put( first, new ArrayList<>() );
            map.get( first ).add( i );
            i++;
        }

        // concate
        i = 0;
        Set<String> res = new HashSet<>();
        for( String line: phrases )
        {
            int lastSpace = line.lastIndexOf( " " );
            String last = (lastSpace >= 0) ? line.substring( lastSpace+1 ) : line;
            // find sentences which last word as leading word
            if( map.containsKey( last ) )
                for( int idx: map.get( last ) )
                {
                    if( idx == i ) continue;
                    res.add( line + phrases[ idx ].substring( last.length() ) );
                }
            i++;
        }
        List<String> ans = new ArrayList<>( res );
        
        // sorted lexicographically
        Collections.sort( ans );
        return ans;
    }
}