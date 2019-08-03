// ref. https://leetcode.com/problems/gray-code/discuss/29891/Share-my-solution

package app;

import java.util.*;

class Q89_gray_code
{
    public List<Integer> grayCode(int n)
    {
        List<Integer> ans = new ArrayList<Integer>();
        // Given: A gray code sequence must begin with 0.
        ans.add( 0 );
        for( int i = 0; i < n; i++ )
        {
            int j = ans.size();
            for( int k = j-1; k >= 0; k-- )
                ans.add( ans.get( k ) | 1 << i );
        }
        return ans;
    }
}