// ref. [KMP Algorithm] https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/

package app;

class Q28_implement_strStr
{
    public int strStr(String haystack, String needle)
    {
        if( haystack == null || needle == null ) return -1;
        return kmp( haystack, needle );
    }

    // Knuth–Morris–Pratt algorithm
    private int kmp( String txt, String pattern )
    {
        int m = txt.length(), n = pattern.length();
        int[] presuffix = new int[ n ];

        // build the prefix-suffix array
        int j = 0, i = 1;
        // the loop calculates lps[i] for i = 1 to M-1
        while( i < n )
        {
            if( pattern.charAt( i ) == pattern.charAt( j ) )
            {
                presuffix[ i ] = ++j; 
                i++; 
            } 
            else // (pat[i] != pat[len]) 
            { 
                // This is tricky. Consider the example AAACAAAA and i = 7. The idea is similar to search step.
                if( j != 0 )
                    j = presuffix[ j-1 ];
                    // note that we do not increment i here
                else // if (len == 0)
                {
                    presuffix[ i ] = j;
                    i++;
                }
            }
        }
        i = 0; j = 0;
        while( i < m && j < n )
        {
            if ( pattern.charAt( j ) == txt.charAt( i ) )
            {
                j++; i++;
            }
            
            if( j == n ) return i-j;
            // mismatch after j matches
            else if( i < m && pattern.charAt( j ) != txt.charAt( i ) )
            {
                if( j > 0 )  j = presuffix[ j-1 ];
                else i++;
            }
        }
        return ( j == n ) ? i-j : -1;
    }
}