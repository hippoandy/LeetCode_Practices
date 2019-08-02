// ref. https://leetcode.com/problems/longest-absolute-file-path/discuss/86666/Java-O(n)-Solution-Using-Stack

package app;

import java.util.*;

// Runtime: 1 ms, faster than 98.00% of Java online submissions for Longest Absolute File Path.
// Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Longest Absolute File Path.
public class Q388_longest_abs_file_path
{
    public int lengthLongestPath(String input)
    {
        String[] item = input.split( "\n" );
        int max = 0;
        int currLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for( String s : item )
        {
            // Find level of the current item, level is calculated by counting number of \t
            int level = 0;
            boolean isFile = false;
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == '\t') level++;
                else if (s.charAt(i) == '.') isFile = true;
            }
            
            // If the current item is a few levels back up, pop the stack
            while( stack.size() > level ) currLen -= stack.pop();

            // plus one because directories and files start with '/' e.g. "/subdir2"
            int itemSize = s.length() + 1 - level;
            currLen += itemSize;
            
            // Only update max if a file is found.
            if( isFile )
                // currLen-1 because the first directory doesn't have '/' in the front
                max = ((currLen - 1) > max) ? currLen - 1 : max;
            // push the current item into stack
            stack.add( itemSize );
        }
        
        return max;
    }
}