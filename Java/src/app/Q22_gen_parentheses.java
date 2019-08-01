package app;

import java.util.*;

// Runtime: 1 ms, faster than 93.44% of Java online submissions for Generate Parentheses.
// Memory Usage: 36.3 MB, less than 99.92% of Java online submissions for Generate Parentheses.
class Q22_gen_parentheses
{
    public List<String> generateParenthesis(int n)
    {
        List<String> ans = new ArrayList<String>();
        backtracking( ans, n, "", 0, 0 );
        return ans;
    }
    
    public void backtracking( List<String> ans, int n, String tmp, int open, int close )
    {
        // n << 1 == n * 2
        if( tmp.length() == (n << 1) )
        {
            ans.add( tmp );
            return;
        }
        
        if( open < n )  // still could append open parenthesis
            backtracking( ans, n, tmp + "(", open+1,   close );
        if( close < open ) // still could append close parenthesis
            backtracking( ans, n, tmp + ")",   open, close+1 );
    }
}