package app;

import java.util.*;

class Q128_longest_consecutive_seq
{
    public int longestConsecutive(int[] nums)
    {
        Set<Integer> set = new HashSet<Integer>();
        
        for( int n: nums ) set.add( n );
        
        int longest = 0;
        for( int n: set )
        {
            // make sure the select n is the valid start point
            // i.e. the smallest element in a sequence
            if( !set.contains( n-1 ) )
            {
                int cur = n, curLen = 1;
                while( set.contains( cur+1 ) ) { cur++; curLen++; }
                longest = (curLen > longest) ? curLen : longest;
            }
        }
        return longest;
    }
}