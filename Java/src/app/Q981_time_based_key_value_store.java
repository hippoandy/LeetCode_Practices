// ref. [Collections.binarySearch()] https://www.geeksforgeeks.org/collections-binarysearch-java-examples/
// ref. [Map.Entry Implementation] https://stackoverflow.com/questions/3110547/java-how-to-create-new-entry-key-value

package app;

import java.util.*;

class Q981_time_based_key_value_store
{
    Map<String, List<MyEntry<Integer, String>>> map;
    /** Initialize your data structure here. */
    public Q981_time_based_key_value_store()
    {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp)
    {
        // if the key is not in map, create the storeage for it in the map
        if( !map.containsKey( key ) )
            map.put( key, new ArrayList<MyEntry<Integer, String>>() );
        // put the value into map
        map.get( key ).add( new MyEntry<Integer, String>( timestamp, value ) );
    }
    
    public String get(String key, int timestamp)
    {
        // if there are no values, it returns the empty string
        if( !map.containsKey( key ) ) return "";
        
        List<MyEntry<Integer, String>> cur = map.get( key );
        
        // returns a value such that set(key, value, timestamp_prev) was called previously, w/ timestamp_prev <= timestamp
        // if there are multiple such values, returns the one w/ largest timestamp_prev
        // find the nearest value in the list of pair
        int idx = Collections.binarySearch( cur, new MyEntry<Integer, String>( timestamp, "" ),
            (a, b) -> Integer.compare( a.getKey(), b.getKey() )
        );
        // new MyEntry<Integer, String>( timestamp, "" ) is just a fake entry to be compared
        
        if( idx >= 0 )       return cur.get( idx ).getValue();
        // before the list, time could not be negative, so return ""
        else if( idx == -1 ) return "";
        else                 return cur.get( -idx-2 ).getValue();
        // idx if not cound will be -i-1, -(idx)-1 = -(-i-1)-2 = i-1
    }
    
    // example from https://stackoverflow.com/questions/3110547/java-how-to-create-new-entry-key-value
    private class MyEntry<K, V> implements Map.Entry<K, V>
    {
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */