// ref. https://leetcode.com/problems/remove-outermost-parentheses/discuss/270022/JavaC%2B%2BPython-Count-Opened-Parenthesis

package app;

class Q1021_remove_outermost_parentheses
{
    public String removeOuterParentheses(String S)
    {
        if( S == null ) return "";
        StringBuilder sol = new StringBuilder();
        
        int open = 0;
        for( char c: S.toCharArray() )
        {
            if( c == '(' && open++ > 0 ) sol.append( '(' );
            if( c == ')' && open-- > 1 ) sol.append( ')' );
        }
        return sol.toString();
    }
}