package app;

class Q780_reaching_points_TLE
{
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return dfs( sx, sy, tx, ty );
    }
    
    private boolean dfs( int x, int y, int tx, int ty )
    {
        if( x > tx || y > ty ) return false;
        if( x == tx && y == ty ) return true;

        return (reachingPoints( x+y, y, tx, ty ) || dfs( x, x+y, tx, ty ));
    }
}