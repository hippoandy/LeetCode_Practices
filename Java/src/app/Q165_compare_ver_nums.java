package app;

// Runtime: 1 ms, faster than 91.19% of Java online submissions for Compare Version Numbers.
// Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Compare Version Numbers.
class Q165_compare_ver_nums
{
    public int compareVersion(String version1, String version2)
    {
        String[] v1 = version1.split( "\\." );
        String[] v2 = version2.split( "\\." );
        int len = (v1.length > v2.length) ? v1.length : v2.length;
        int sum1 = 0, sum2 = 0;
        for( int i = 0; i < len; i++ )
        {
            if( i < v1.length )
                sum1 += Integer.parseInt( v1[ i ] );
            if( i < v2.length )
                sum2 += Integer.parseInt( v2[ i ] );
            
            if( sum1 == sum2 ) continue;
            else
                return (sum1 > sum2) ? 1 : -1;
        }
        return 0;
    }
}