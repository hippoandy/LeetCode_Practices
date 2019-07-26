// ref. https://leetcode.com/problems/ransom-note/discuss/85783/Java-O(n)-Solution-Easy-to-understand

package app;

class Q383_ransom_note
{
    public boolean canConstruct(String ransomNote, String magazine)
    {
        int r = ransomNote.length();
        int m = magazine.length();
        if( r == 0 && m == 0 ) return true;
        if( r == 0 && m != 0 ) return true;
        if( r != 0 && m == 0 ) return false;
        
        int[] count = new int[ 26 ]; // 26 alphabet
        for( int i = 0; i < m; i++ )
            count[ magazine.charAt( i ) - 'a' ]++;
        for( int i = 0; i < r; i++ )
            if( --count[ ransomNote.charAt( i ) - 'a' ] < 0 ) return false;
        return true;
    }
}