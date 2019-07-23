package app;

class Q883_projection_area_of_3d_shapes
{
    public int projectionArea(int[][] grid)
    {
        if( grid == null )     return 0;
        if( grid.length == 0 ) return 0;

        int N = grid.length;

        int area = 0;
        // iterate through the whole grid, find max value in each row and max value in each column, add all of the found value in to the answer
        // since 1 cube generates 1 grid
        for( int i = 0; i < N; i++ )
        {
            int max_row = 0; // row w/ max value
            int max_col = 0; // column w/ max value
            for( int j = 0; j < N; j++ )
            {
                // bottom area (xy plane) should be number of the non-zero elements
                if( grid[ i ][ j ] != 0 ) area++;
                // from the side, the shadow made by the shape will be the largest value for each row in the grid.
                max_row = Math.max( max_row, grid[ i ][ j ] );
                // from the front, the shadow made by the shape will be the largest value for each column in the grid.
                max_col = Math.max( max_col, grid[ j ][ i ] );
            }
            area += max_row + max_col;
        }
        return area;
    }
}