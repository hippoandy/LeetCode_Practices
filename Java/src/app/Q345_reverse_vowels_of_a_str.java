// ref. https://leetcode.com/problems/reverse-vowels-of-a-string/discuss/81225/Java-Standard-Two-Pointer-Solution

package app;

import java.util.*;

class Q345_reverse_vowels_of_a_str
{
    Set<Character> vowels;
    public String reverseVowels(String s)
    {
        if( s == null ) return "";
        if( s.length() == 0 ) return "";

        buildTable();
        
        char[] str = s.toCharArray();
        int l = 0, r = s.length()-1;
        while( l < r )
        {
            while( l < r && !vowels.contains( str[ l ] ) ) l++;
            while( l < r && !vowels.contains( str[ r ] ) ) r--;
            
            if( l < r )
            {
                // swap
                char t = str[ l ];
                str[ l ] = str[ r ];
                str[ r ] = t;
                
                l++; r--;
            }
        }
        return new String( str );
    }
    
    private void buildTable()
    {
        vowels = new HashSet<Character>(
            Arrays.asList( 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' )
        );
    }
}