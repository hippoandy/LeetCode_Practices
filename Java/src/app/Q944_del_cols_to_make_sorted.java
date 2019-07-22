package app;

class Q944_del_cols_to_make_sorted
{
    public int minDeletionSize(String[] A)
    {
        int ans = 0;
        if( A == null ) return ans;
        if( A.length == 0 ) return ans;

        // go through all the char
        for( int i = 0; i < A[ 0 ].length(); i++ )
            // go through all the words
            for( int w = 0; w < A.length - 1; w++ )
                if( A[ w ].charAt( i ) > A[ w + 1 ].charAt( i ) )
                {
                    ans++;
                    break;
                }
        return ans;
    }
}