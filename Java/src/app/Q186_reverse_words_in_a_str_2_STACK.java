package app;

import java.util.*;

// Runtime: 9 ms, faster than 5.40% of Java online submissions for Reverse Words in a String II.
// Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Reverse Words in a String II.
class Q186_reverse_words_in_a_str_2_STACK
{
    public void reverseWords(char[] s)
    {
        Stack<String> stack = new Stack<String>();
        String current = "";
        for( char c: s )
        {
            if( c != ' ' ) current += c;
            else
            {
                if( !current.equals( "" ) )
                {
                    stack.push( current );
                    // reset
                    current = "";
                }
            }
        }
        if( !current.equals( "" ) )
        {
            stack.push( current );
            // reset
            current = "";
        }
        int i = 0;
        while( !stack.isEmpty() )
        {
            String word = stack.pop();
            for( char c: word.toCharArray() ) s[ i++ ] = c;
            if( !stack.isEmpty() ) s[ i++ ] = ' ';
        }
    }
}