package app;

class Q942_di_str_match
{
    public int[] diStringMatch(String S)
    {
        int N = S.length();
        int[] ans = new int[ N + 1 ];
        
        int low = 0, high = N;
        for( int i = 0; i < N; i++ )
        {
            if( S.charAt( i ) == 'I' ) ans[ i ] = low++;
            else                       ans[ i ] = high--;
        }
        // remember the array is longer than the string
        ans[ N ] = low;
        return ans;
    }
}