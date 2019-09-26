import java.util.*;

class Q301_rm_invalid_parentheses
{
    public List<String> removeInvalidParentheses(String s)
    {
        List<String> res = new ArrayList<String>();
        // s with length 0 will be a valid input!!
        if( s == null ) return res;
        
        Set<String> visited = new HashSet<String>();
        
        Queue<String> q = new LinkedList<String>();
        q.offer( s );
        // mark as visited
        visited.add( s );
        
        boolean found = false;
        
        // perform bfs
        while( !q.isEmpty() )
        {
            String cur = q.remove();
            
            if( isValid( cur ) )
            {
                res.add( cur );
                found = true;
            }
            
            // remove the minimum number of invalid parentheses in order to make the input string valid.
            // if we already found a solution, don't need to keep reducing the string
            if( found ) continue;
            
            // try to remove a char
            // all the possible states will be generated
            for( int i = 0; i < cur.length(); i++ )
            {
                // only need to remove '(' or ')', there might be other char in the input
                if( cur.charAt( i ) != '(' && cur.charAt( i ) != ')' ) continue;

                String t = cur.substring( 0, i ) + cur.substring( i+1 );
                
                if( visited.contains( t ) ) continue;
                q.offer( t );
                visited.add( t );
            }
        }
        return res;
    }
    
    // check if the parathethis pair is valid
    private boolean isValid( String s )
    {
        int count = 0;
        for( char c: s.toCharArray() )
        {
            if( c == '(' ) count++;
            if( c == ')' )
            {
                if( count == 0 ) return false;
                count--;
            }
        }
        return count == 0;
    }
}