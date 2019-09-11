package app;

class Q722_rm_comments
{
    public List<String> removeComments(String[] source)
    {
        List<String> res = new ArrayList<String>();
        
        boolean unclosed = false;
        
        String tmp = "";
        
        for( String s: source )
        {
            char[] line = s.toCharArray();
            
            int i = 0;
            int n = line.length;
            while( i < n )
            {
                if( !unclosed && i+1 < n && line[ i ] == '/' && line[ i+1 ] == '*' )
                {
                    unclosed = true;
                    i += 2;
                }
                else if( unclosed && i+1 < n && line[ i ] == '*' && line[ i+1 ] == '/' )
                {
                    unclosed = false;
                    i += 2;
                }
                else if( !unclosed && i+1 < n && line[ i ] == '/' && line[ i+1 ] == '/' )
                {
                    i = line.length;
                }
                else if( !unclosed )
                    tmp += line[ i++ ];
                else
                    i++;
            }
            if( !unclosed && tmp.length() > 0 )
            {
                res.add( tmp );
                // reset the tmp string
                tmp = "";
            }
        }
        return res;
    }
}