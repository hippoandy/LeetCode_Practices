// ref. https://leetcode.com/problems/island-perimeter/discuss/94992/Java-9-line-solution-add-4-for-each-land-and-remove-2-for-each-internal-edge

package app;

class Q463_island_perimeter
{
    // intuitive brute-force
    // traverse the grid
    public int islandPerimeter(int[][] grid)
    {
        if( grid == null ) return 0;
        if( grid.length == 0 ) return 0;
        if( grid[ 0 ].length == 0 ) return 0;

        int perimeter = 0;
        for( int i = 0; i < grid.length; i++ )
            for( int j = 0; j < grid[ 0 ].length; j++ )
                if( grid[ i ][ j ] == 1 )
                {
                    perimeter += 4;
                    // just check left and up since those 2 are previously visited
                    if( i > 0 && grid[ i-1 ][ j ] == 1 ) perimeter -= 2;
                    if( j > 0 && grid[ i ][ j-1 ] == 1 ) perimeter -= 2;
                }
        return perimeter;
    }

    // Math solution
    // public int islandPerimeter(int[][] grid)
    // {
    //     int island = 0, neighbor = 0;
    //     for( int i = 0; i < grid.length; i++ )
    //         for( int j = 0; j < grid[ 0 ].length; j++ )
    //         {
    //             if( grid[ i ][ j ] == 1 )
    //             {
    //                 island++;
    //                 if( i + 1 < grid.length )
    //                     if( grid[ i + 1 ][ j ] == 1 ) neighbor++;
    //                 if( j + 1 < grid[ 0 ].length )
    //                     if( grid[ i ][ j + 1 ] == 1 ) neighbor++;
    //             }
    //         }
    //     return 4 * island - 2 * neighbor;
    // }
}