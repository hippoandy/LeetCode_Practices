package app;

// Runtime: 2 ms, faster than 53.66% of Java online submissions for Lexicographically Smallest Equivalent String.
// Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Lexicographically Smallest Equivalent String.
class Q1061_lexicographically_smallest_equivalent_str
{
    private int[] parent;
    private int[] rank;

    public String smallestEquivalentString(String A, String B, String S)
    {
        // corner cases
        if( S == null || S.equals( "" ) ) return S;
        if( A == null || B == null ) throw new IllegalArgumentException( "Input A or B is null!" );
        if( A.length() != B.length() ) throw new IllegalArgumentException( "A and B are not in the same length!" );

        parent = new int[ 26 ]; rank = new int[ 26 ];
        for( int i = 0; i < parent.length; i++ ) parent[ i ] = rank[ i ] = i;

        for( int i = 0; i < A.length(); i++ )
            unify( A.charAt( i ) - 'a', B.charAt( i ) - 'a' );

        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < S.length(); i++ )
            sb.append( (char) (find( S.charAt( i ) - 'a' ) + 'a') );
        return sb.toString();
    }
    
    public int find( int x )
    {
        while( x != parent[ x ] )
        {
            parent[ x ] = parent[ parent[ x ] ];
            x = parent[ x ];
        }
        return x;
    }
    
    public void unify( int x, int y )
    {
        int p1 = find( x ), p2 = find( y );
        if( p1 != p2 )
        {   // return the lexicographically smallest equivalent string
            if( rank[ p1 ] > rank[ p2 ] )
                parent[ p1 ] = p2;
            else
                parent[ p2 ] = p1;
        }
    }
}