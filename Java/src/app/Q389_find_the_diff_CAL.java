// ref. https://leetcode.com/problems/find-the-difference/discuss/86850/Simple-JAVA-8ms-solution-4-lines

package app;

// Runtime: 1 ms, faster than 99.05% of Java online submissions for Find the Difference.
// Memory Usage: 37.6 MB, less than 8.12% of Java online submissions for Find the Difference.
class Q389_find_the_diff_CAL
{
    public char findTheDifference(String s, String t)
    {
        // t is just 1 char larger that s
        int charCode = t.charAt( s.length() );
        // Iterate through both strings and char codes
        for( int i = 0; i < s.length(); i++ )
        {
              charCode -= (int) s.charAt( i );
              charCode += (int) t.charAt( i ); 
        }
        return (char) charCode;
    }
}