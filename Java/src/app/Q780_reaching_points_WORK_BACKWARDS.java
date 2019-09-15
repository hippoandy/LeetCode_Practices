package app;

class Q780_reaching_points_WORK_BACKWARDS
{
    public boolean reachingPoints(int sx, int sy, int tx, int ty)
    {
        while( tx >= sx && ty >= sy )
        {
            if( tx == ty ) break;
            if( tx > ty )
            {
                // case (x-y, y)
                if( ty > sy )   tx %= ty;
                // y matches (ty == sy)
                else return (tx - sx) % ty == 0;
            }
            else
            {
                // case (x, y-x)
                if( tx > sx ) ty %= tx;
                // x matches (tx == sx)
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx) && (ty == sy);
    }
}