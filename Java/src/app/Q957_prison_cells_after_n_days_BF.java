package app;

// Time limit exceeded!
class Q957_prison_cells_after_n_days_BF
{
    public int[] prisonAfterNDays(int[] cells, int N)
    {
        if( cells == null || cells.length == 0 ) return new int[ 0 ];
        if( N < 1 ) throw new IllegalArgumentException( "Num. of days less than 1!" );
        
        int len = cells.length;
        
        int[] next = null;
        while( N > 0 )
        {
            next = new int[ len ];
            for( int i = 1; i < len-1; i++ )
            {
                if( cells[ i-1 ] == cells[ i+1 ] ) next[ i ] = 1;
                else next[ i ] = 0;
            }
            cells = next;
            N--;
        }
        return next;
    }
}