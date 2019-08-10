// ref. https://leetcode.com/problems/design-phone-directory/discuss/85328/Java-AC-solution-using-queue-and-set

package app;

import java.util.*;

class Q379_design_phone_dict
{
    class PhoneDirectory
    {
        Queue<Integer> available;
        Set<Integer> book;
        int max;

        /** Initialize your data structure here
            @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers)
        {
            this.available = new LinkedList<Integer>();
            for( int i = 0; i < maxNumbers; i++ )
                this.available.offer( i );
            this.book = new HashSet<Integer>();
            this.max = maxNumbers;
        }
        
        /** Provide a number which is not assigned to anyone.
            @return - Return an available number. Return -1 if none is available. */
        public int get()
        {
            if( this.available.isEmpty() ) return -1;

            int ret = this.available.remove();
            book.add( ret );
            return ret;
        }
        
        /** Check if a number is available or not. */
        public boolean check( int number )
        {
            if( number >= this.max || number < 0 ) return false;

            if( this.book.contains( number ) ) return false;
            return true;
        }
        
        /** Recycle or release a number. */
        public void release(int number)
        {
            if( number >= this.max || number < 0 ) return;

            if( this.book.remove( number ) )
                this.available.offer( number );
        }
    }

    /**
     * Your PhoneDirectory object will be instantiated and called as such:
     * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
     * int param_1 = obj.get();
     * boolean param_2 = obj.check(number);
     * obj.release(number);
     */
}