package app;

import java.util.*;

class Q228_summary_ranges
{
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Summary Ranges.
    // Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Summary Ranges.
    public List<String> summaryRanges(int[] nums)
    {
        List<String> ans = new ArrayList<String>();
        if( nums == null ) return ans;
        if( nums.length == 0 ) return ans;

        for (int i = 0, j = 0; j < nums.length; j++ )
        {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            // put the range [nums[i], nums[j]] into the list
            if (i == j)
                ans.add(nums[i] + "");
            else
                ans.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return ans;
    }

    // // Runtime: 0 ms, faster than 100.00% of Java online submissions for Summary Ranges.
    // // Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Summary Ranges.
    // public List<String> summaryRanges(int[] nums)
    // {
    //     List<String> ans = new ArrayList<String>();
    //     if( nums == null ) return ans;
    //     if( nums.length == 0 ) return ans;
        
    //     int s = nums[ 0 ], e = nums[ 0 ];
    //     for( int i = 1; i < nums.length; i++ )
    //     {
    //         if( nums[ i ] > e+1 )
    //         {
    //             appendList( ans, s, e );
    //             s = e = nums[ i ];
    //         }
    //         else
    //             e = nums[ i ];
    //     }
    //     appendList( ans, s, e );
        
    //     return ans;
    // }
    // private void appendList( List<String> ans, int s, int e )
    // {
    //     if( s == e )
    //         ans.add( Integer.toString( e ) );
    //     else
    //         ans.add( Integer.toString( s ) + "->" + Integer.toString( e ) );
    // }
}