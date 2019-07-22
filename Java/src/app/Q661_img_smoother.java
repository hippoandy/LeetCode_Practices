package app;

// Time Complexity: O(N)O(N), where NN is the number of pixels in our image. We iterate over every pixel.
// Space Complexity: O(N)O(N), the size of our answer.
class Q661_img_smoother
{
    public int[][] imageSmoother(int[][] M)
    {
        int m = M.length, n = M[ 0 ].length;
        int[][] ans = new int[ m ][ n ];

        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
            {
                int count = 0;
                // go through all the neighbor
                for( int nr = i-1; nr <= i+1; nr++ )
                    for( int nc = j-1; nc <= j+1; nc++ )
                        if( nc >= 0 && nc < n && nr >= 0 && nr < m )
                        {
                            ans[ i ][ j ] += M[ nr ][ nc ];
                            count += 1;
                        }
                ans[ i ][ j ] /= count;
            }
        return ans;
    }
}