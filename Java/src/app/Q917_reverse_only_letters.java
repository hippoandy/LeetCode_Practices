package app;

class Q917_reverse_only_letters
{
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Only Letters.
    // Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Reverse Only Letters.
    public String reverseOnlyLetters(String S)
    {
        if( S == null ) return S;
        if( S.length() == 0 ) return S;

        int l = 0, r = S.length()-1;
        char[] str = S.toCharArray();
        while( l < r )
        {
            while( l < r && !Character.isLetter( str[ l ] ) ) l++;
            while( l < r && !Character.isLetter( str[ r ] ) ) r--;
            
            // swap
            char t = str[ l ];
            str[ l ] = str[ r ];
            str[ r ] = t;
            
            l++;
            r--;
        }
        return new String( str );
    }

    // // Runtime: 1 ms, faster than 55.14% of Java online submissions for Reverse Only Letters.
    // // Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Reverse Only Letters.
    // public String reverseOnlyLetters(String S)
    // {
    //     StringBuilder sb = new StringBuilder(S);
    //     for (int i = 0, j = S.length() - 1; i < j; ++i, --j) {
    //         while( i < j && !Character.isLetter( sb.charAt( i ) ) ) i++;
    //         while( i < j && !Character.isLetter( sb.charAt( j ) ) ) j--;
    //         sb.setCharAt( i, S.charAt( j ) );
    //         sb.setCharAt( j, S.charAt( i ) );
    //     }
    //     return sb.toString();
    // }
}