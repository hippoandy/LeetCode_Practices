package app;

import java.util.*;

// Runtime: 11 ms, faster than 66.16% of Java online submissions for Subdomain Visit Count.
// Memory Usage: 38.5 MB, less than 89.68% of Java online submissions for Subdomain Visit Count.
// class Q811_subdomain_visit_count
// {
//     public List<String> subdomainVisits(String[] cpdomains)
//     {
//         List<String> ans = new ArrayList<String>();
//         if( cpdomains == null ) return ans;
//         if( cpdomains.length == 0 ) return ans;

//         Map<String, Integer> map = new HashMap<String, Integer>();
        
//         for( String domain: cpdomains )
//         {
//             // get the count of visit
//             String[] parts = domain.split( " " );
//             int count = Integer.parseInt( parts[ 0 ] );

//             String[] sub = parts[ 1 ].split( "\\." );
//             for( int i = 0; i < sub.length; i++ )
//             {
//                 String addr = sub[ i ];
//                 for( int j = i + 1; j < sub.length; j++ )
//                     addr += "." + sub[ j ];
//                 map.put( addr, map.getOrDefault( addr, 0 ) + count );
//             }
//         }

//         for( Map.Entry<String, Integer> entry: map.entrySet() )
//             ans.add( entry.getValue() + " " + entry.getKey() );
//         return ans;
//     }
// }

// logic improved
class Q811_subdomain_visit_count
{
    public List<String> subdomainVisits(String[] cpdomains)
    {
        List<String> ans = new ArrayList<String>();
        if( cpdomains == null ) return ans;
        if( cpdomains.length == 0 ) return ans;

        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for( String domain: cpdomains )
        {
            // get the count of visit
            String[] parts = domain.split( " " );
            int count = Integer.parseInt( parts[ 0 ] );

            String[] sub = parts[ 1 ].split( "\\." );
            // for( int i = 0; i < sub.length; i++ )
            // {
            //     String addr = sub[ i ];
            //     for( int j = i + 1; j < sub.length; j++ )
            //         addr += "." + sub[ j ];
            //     map.put( addr, map.getOrDefault( addr, 0 ) + count );
            // }
            String addr = "";
            for( int i = sub.length - 1; i >= 0; i-- )
            {
                addr = sub[ i ] + ( i < sub.length - 1 ? "." : "" ) + addr;
                map.put( addr, map.getOrDefault( addr, 0 ) + count );
            }
        }

        for( Map.Entry<String, Integer> entry: map.entrySet() )
            ans.add( entry.getValue() + " " + entry.getKey() );
        return ans;
    }
}