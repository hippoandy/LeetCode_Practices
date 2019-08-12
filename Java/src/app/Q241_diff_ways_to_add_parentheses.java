// ref. https://leetcode.com/problems/different-ways-to-add-parentheses/discuss/66452/Divide-and-conquer-%2B-cache-___Java__260ms

package app;

import java.util.*;

// Runtime: 3 ms, faster than 31.60% of Java online submissions for Different Ways to Add Parentheses.
// Memory Usage: 39.7 MB, less than 70.83% of Java online submissions for Different Ways to Add Parentheses.
public class Q241_diff_ways_to_add_parentheses
{
    Map<String, List<Integer>> cache = new HashMap<String, List<Integer>>();

    public List<Integer> diffWaysToCompute(String input)
    {
        if( cache.containsKey( input ) ) return cache.get( input );
        
        List<Integer> res = new ArrayList<Integer>();
        
        for( int i = 0; i < input.length(); i++ )
        {
            char c = input.charAt( i );
            if( !Character.isDigit( c ) )
            {
                // divided into 2 parts
                List<Integer> l = diffWaysToCompute( input.substring( 0, i ) );
                List<Integer> r = diffWaysToCompute( input.substring( i+1 ) );
                for( int x: l )
                    for( int y: r )
                        switch( c )
                        {
                            case '+': res.add( x + y ); break;
                            case '-': res.add( x - y ); break;
                            case '*': res.add( x * y ); break;
                        }
            }
        }
        // base case, only operand
        // this will deal with the number more than 1 digit!
        if( res.isEmpty() ) res.add( Integer.parseInt( input ) );
        
        return res;
    }
}