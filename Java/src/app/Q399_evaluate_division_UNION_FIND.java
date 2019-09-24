// ref. https://leetcode.com/problems/evaluate-division/discuss/88170/0ms-C%2B%2B-Union-Find-Solution-EASY-to-UNDERSTAND

// The idea is that, given a query [a, b],
// if they share the same root,
// find out the value of common_root/a and comon_root/b,
// then the result is (comon_root/b) / (comon_root/a)

package app;

class Q399_evaluate_division_UNION_FIND
{
//     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
//     {
//         // building the graph
//         Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
//         for( int i = 0; i < values.length; i++ )
//         {
//             String a = equations.get( i ).get( 0 );
//             String b = equations.get( i ).get( 1 );
//             if( !map.containsKey( a ) )
//                 map.put( a, new HashMap<String, Double>() );
//             if( !map.containsKey( b ) )
//                 map.put( b, new HashMap<String, Double>() );
//             map.get( a ).put( b, values[ i ] );
//             map.get( b ).put( a, 1 / values[ i ] );
//         }
        
//         // solution set
//         double[] sol = new double[ queries.size() ];
//         for( int i = 0; i < queries.size(); i++ )
//             sol[ i ] = dfs( queries.get( i ).get( 0 ), queries.get( i ).get( 1 ), 1, map, new HashSet<String>() );
//         return sol;
//     }
    
//     public double dfs( String a, String b, double tmp, Map<String, Map<String, Double>> map, Set<String> visited )
//     {
//         // a is not in the graph or a is already visited
//         // Set.add() return false if the operation failed (element exists)
//         // if( !map.containsKey( a ) || !visited.add( a ) ) return -1;
//         if( !map.containsKey( a ) ) return -1;
//         if( visited.contains( a ) ) return -1;
//         visited.add( a );

//         if( a.equals( b ) ) return tmp;

//         // get the edges
//         Map<String, Double> edges = map.get( a );
//         for( String c: edges.keySet() )
//         {
//             double ans = dfs( c, b, tmp * edges.get( c ), map, visited );
//             if( ans != -1 ) return ans;
//         }
        
//         return -1;
//     }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> ratio = new HashMap<>();
        
        for( int i = 0; i < equations.size(); i++ )
            unify( parent, ratio, equations.get( i ).get( 0 ), equations.get( i ).get( 1 ), values[ i ] );
        
        double[] res = new double[ queries.size() ];
        int i = 0;
        for( List<String> query: queries )
        {
            String x = query.get( 0 ), y = query.get( 1 );
            if( !parent.containsKey( x ) || !parent.containsKey( y ) ||
               !find( parent, ratio, x ).equals( find( parent, ratio, y ) )
            )
                res[ i ] = -1;
            else
                res[ i ] = ratio.get( x ) / ratio.get( y );
            i++;
        }
        return res;
    }
    
    private String find( Map<String, String> parent, Map<String, Double> ratio, String x )
    {
        if( x.equals( parent.get( x ) ) ) return x;
        
        String father = parent.get( x );
        String grandpa = find( parent, ratio, father );
        
        parent.put( x, grandpa );
        ratio.put( x, ratio.get( x ) * ratio.get( father ) );
        return grandpa;
    }
    
    private void unify( Map<String, String> parent, Map<String, Double> ratio, String x, String y, double val )
    {
        if( !parent.containsKey( x ) ) { parent.put( x, x ); ratio.put( x, 1.0 ); }
        if( !parent.containsKey( y ) ) { parent.put( y, y ); ratio.put( y, 1.0 ); }
        
        String root_x = find( parent, ratio, x ),
               root_y = find( parent, ratio, y );
        
        parent.put( root_x, root_y );
        ratio.put( root_x, val * ratio.get( y ) / ratio.get( x ) );
    }
}