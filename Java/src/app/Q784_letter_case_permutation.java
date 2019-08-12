package app;

import java.util.*;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Letter Case Permutation.
// Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Letter Case Permutation.
class Q784_letter_case_permutation
{
    List<String> res;

    public List<String> letterCasePermutation(String S)
    {
        res = new ArrayList<String>();
        backtracking( S, 0 );
        return res;
    }
    
    private void backtracking( String S, int start )
    {
        if( start > S.length() ) return;
        res.add( S );
        for( int i = start; i < S.length(); i++ )
        {
            char c = S.charAt( i );
            char[] str = S.toCharArray();
            if( c >= 'a' && c <= 'z' )
                str[ i ] = (char) (c - 32);
            else if( c >= 'A' && c <= 'Z' )
                str[ i ] = (char) (c + 32);
            else continue;

            backtracking( new String( str ), i+1 );
        }
    }
}