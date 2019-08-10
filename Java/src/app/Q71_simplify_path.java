// ref. https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack

package app;

import java.util.*;

class Q71_simplify_path
{
    public String simplifyPath(String path)
    {
        Stack<String> stack = new Stack<String>();
        Set<String> skip = new HashSet<String>( Arrays.asList( "..", ".", "" ) );

        for( String p: path.split("/") )
        {
            if( p.equals( ".." ) && !stack.isEmpty() ) stack.pop();
            else
                if( !skip.contains( p ) )
                    stack.push( p );
        }
        path = "";
        while( !stack.isEmpty() ) path = "/" + stack.pop() + path;
        return path.isEmpty() ? "/" : path;
    }
}