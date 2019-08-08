package app;

import java.util.*;

// Runtime: 71 ms, faster than 84.91% of Java online submissions for Logger Rate Limiter.
// Memory Usage: 55.8 MB, less than 100.00% of Java online submissions for Logger Rate Limiter.
class Q359_logger_rate_limiter
{
    class Logger
    {
        Map<String, Integer> map;

        /** Initialize your data structure here. */
        public Logger()
        {
            this.map = new HashMap<String, Integer>();
        }
        
        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
            If this method returns false, the message will not be printed.
            The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message)
        {
            boolean print = true;
            if( !this.map.containsKey( message ) )
                this.map.put( message, timestamp );
            else
            {
                if( Math.abs( this.map.get( message ) - timestamp ) < 10 )
                    print = false;
                else
                    this.map.put( message, timestamp );
            }
            return print;
        }
    }

    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */
}