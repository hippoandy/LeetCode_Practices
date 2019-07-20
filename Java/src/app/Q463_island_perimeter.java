package app;

class Q463_island_perimeter
{
    public int islandPerimeter(int[][] grid)
    {
        int island = 0, neighbor = 0;
        for( int i = 0; i < grid.length; i++ )
            for( int j = 0; j < grid[ 0 ].length; j++ )
            {
                if( grid[ i ][ j ] == 1 )
                {
                    island++;
                    if( i + 1 < grid.length )
                        if( grid[ i + 1 ][ j ] == 1 ) neighbor++;
                    if( j + 1 < grid[ 0 ].length )
                        if( grid[ i ][ j + 1 ] == 1 ) neighbor++;
                }
            }
        return 4 * island - 2 * neighbor;
    }
}