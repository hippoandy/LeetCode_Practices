package app;

import java.util.*;

// Runtime: 2 ms, faster than 61.07% of Java online submissions for Valid Parentheses.
// Memory Usage: 34.8 MB, less than 99.82% of Java online submissions for Valid Parentheses.
class Q20_valid_parentheses
{
    Map<String, String> table;
    Stack<String> stack = new Stack<String>();
    public boolean isValid(String s)
    {
        buildTable();
        String left = "([{";
        for( int i = 0; i < s.length(); i++ )
        {
            String cur = s.substring( i, i+1 );
            if( left.contains( cur ) )
                stack.push( cur );
            else
            {
                // if there is no left part to match
                if( stack.isEmpty() ) return false;
                String pop = stack.pop();
                if( !pop.equals( table.get( cur ) ) ) return false;
            }
        }
        // if there is no right part to match
        if( !stack.isEmpty() ) return false;
        return true;
    }
    
    private void buildTable()
    {
        table = new HashMap<String, String>();
        table.put( "(", ")" );
        table.put( ")", "(" );
        table.put( "[", "]" );
        table.put( "]", "[" );
        table.put( "{", "}" );
        table.put( "}", "{" );
    }

    // Runtime: 2 ms, faster than 61.07% of Java online submissions for Valid Parentheses.
    // Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Valid Parentheses.
    // Map<Character, Character> table;
    // Stack<Character> stack = new Stack<Character>();
    // public boolean isValid(String s)
    // {
    //     buildTable();
    //     for( int i = 0; i < s.length(); i++ )
    //     {
    //         char c = s.charAt( i );
    //         switch( c )
    //         {
    //             case '(':
    //             case '[':
    //             case '{':
    //                 stack.push( c );
    //                 break;
    //             default:
    //                 // if there is no left part to match
    //                 if( stack.isEmpty() ) return false;
    //                 if( stack.pop() != table.get( c ) ) return false;
    //                 break;
    //         }
    //     }
    //     // if there is no right part to match
    //     if( !stack.isEmpty() ) return false;
    //     return true;
    // }
    
    // private void buildTable()
    // {
    //     table = new HashMap<Character, Character>();
    //     table.put( '(', ')' );
    //     table.put( ')', '(' );
    //     table.put( '[', ']' );
    //     table.put( ']', '[' );
    //     table.put( '{', '}' );
    //     table.put( '}', '{' );
    // }
}