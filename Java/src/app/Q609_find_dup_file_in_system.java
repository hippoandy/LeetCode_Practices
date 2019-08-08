// ref. [Regex Solution] https://stackoverflow.com/questions/24256478/pattern-to-extract-text-between-parenthesis

package app;

import java.util.*;

class Q609_find_dup_file_in_system
{
    public List<List<String>> findDuplicate(String[] paths)
    {
        List<List<String>> ans = new ArrayList<List<String>>();
        if( paths == null ) return ans;
        if( paths.length == 0 ) return ans;
            
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for( String p: paths )
        {
            String[] parts = p.split( " " );
            for( int i = 1; i< parts.length; i++ )
            {
                String key = parts[ i ].substring( parts[ i ].indexOf( "(" )+1,
                                                   parts[ i ].indexOf( ")" ) );
                String filepath = parts[ 0 ] + "/" +
                                  parts[ i ].substring( 0, parts[ i ].indexOf( "(" ) );
                
                if( !map.containsKey( key ) )
                    map.put( key, new ArrayList<String>() );
                map.get( key ).add( filepath );
            }
        }
        
        for( String k: map.keySet() )
        {   // get the duplicate only
            if( map.get( k ).size() > 1 )
                ans.add( map.get( k ) );
        }
        return ans;
    }
}