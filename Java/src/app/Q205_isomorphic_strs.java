// ref. https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution

package app;

class Q205_isomorphic_strs
{
    // The idea is that we need to map a char to another one.
    //  Instead of directly mapping 'e' to 'a', another way is to mark them with same value, for example, 'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same.
    public boolean isIsomorphic(String s, String t)
    {
        // ASCII table has 256 char
        int[] m1 = new int[ 256 ], m2 = new int[ 256 ];
        
        for( int i = 0; i < s.length(); i++ )
        {
            char s_cur = s.charAt( i );
            char t_cur = t.charAt( i );
            if( m1[ s_cur ] != m2[ t_cur ] ) return false;
            m1[ s_cur ] = i+1;
            m2[ t_cur ] = i+1;
        }
        return true;
    }
}