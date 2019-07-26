// ref. https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/85401/Java-solution-using-a-HashMap-and-an-ArrayList-along-with-a-follow-up.-(131-ms)

package app;

import java.util.*;

class Q380_insert_del_getrandom_o1
{
    List<Integer> nums;
    Map<Integer, Integer> map; // keep tracking the location of the value
    Random rand;

    /** Initialize your data structure here. */
    public Q380_insert_del_getrandom_o1()
    {
        this.nums = new ArrayList<Integer>();
        this.map = new HashMap<Integer, Integer>();
        this.rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val)
    {
        if( map.containsKey( val ) ) return false;

        this.map.put( val, nums.size() );
        // add to the tail
        this.nums.add( val );
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val)
    {
        if( !map.containsKey( val ) ) return false;
        int loc = map.get( val );
        // if the val is not at the tail, swap it with the tail
        if( loc < nums.size() - 1 )
        {
            // get the value of the last element
            int last = nums.get( nums.size() - 1 );
            // put the last element into loc at the array
            nums.set( loc, last );
            map.put( last, loc );
        }
        map.remove( val );
        nums.remove( nums.size() - 1 );
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom()
    {
        return nums.get( rand.nextInt( nums.size() ) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */