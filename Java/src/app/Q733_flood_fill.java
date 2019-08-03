package app;

class Q733_flood_fill
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int color = image[ sr ][ sc ];
        if( color != newColor ) dfs( image, sr, sc, color, newColor );
        return image;
    }
    
    private void dfs( int[][] image, int r, int c, int color, int newColor )
    {
        if( image[ r ][ c ] == color )
        {
            image[ r ][ c ] = newColor;
            // up
            if( r >= 1 ) dfs( image, r-1, c, color, newColor );
            // down
            if( r < image.length-1 ) dfs( image, r+1, c, color, newColor );
            // left
            if( c >= 1 ) dfs( image, r, c-1, color, newColor );
            // right
            if( c < image[ 0 ].length-1 ) dfs( image, r, c+1, color, newColor );
        }
    }
}