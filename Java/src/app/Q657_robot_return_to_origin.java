package app;

class Q657_robot_return_to_origin
{
    public boolean judgeCircle(String moves)
    {
        int x = 0, y = 0;
        for( int i = 0; i < moves.length(); i++ )
        {
            char c = moves.charAt( i );
            switch( c )
            {
                case 'U': y -= 1; break;
                case 'D': y += 1; break;
                case 'L': x -= 1; break;
                case 'R': x += 1; break;
            }
        }
        return (x == 0 && y == 0);
    }
}