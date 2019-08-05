package app;

import java.util.*;

class Q636_exclusive_time_of_functions
{
    public int[] exclusiveTime(int n, List<String> logs)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int[] exclusive = new int[ n ];
        
        String[] log = logs.get( 0 ).split( ":" );
        // log[ 0 ]: function id
        // log[ 1 ]: label -> start/end
        // log[ 2 ]: timestamp
        stack.push( Integer.parseInt( log[ 0 ] ) );

        // index for the list
        int i = 1;
        // previous timestamp
        int pre = Integer.parseInt( log[ 2 ] );
        while( i < logs.size() )
        {
            log = logs.get( i ).split( ":" );
            if( log[ 1 ].equals( "start" ) )
            {
                if( !stack.isEmpty() )
                    // calculate the time difference
                    exclusive[ stack.peek() ] += Integer.parseInt( log[ 2 ] ) - pre;
                // push the current id into stack
                stack.push( Integer.parseInt( log[ 0 ] ) );
                pre = Integer.parseInt( log[ 2 ] );
            }
            // end
            else
            {
                // "+1" is to count the last time slot in!
                exclusive[ stack.peek() ] += Integer.parseInt( log[ 2 ] ) + 1 - pre;
                stack.pop();
                pre = Integer.parseInt( log[ 2 ] ) + 1;
            }
            // go to next log entry
            i++;
        }
        // the result is already sorted by function id since we are using stack
        return exclusive;
    }
}