package test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by doshest on 2017/5/31.
 */
public class LinkedHashMapTest<K,V> {
   private final int MAX_SIZE ;
   private final float DEFAULT_LOAD_FACTORY = 0.75F;
   LinkedHashMap<K,V> map;

    public LinkedHashMapTest(int max_size) {
        MAX_SIZE = max_size;
        int capacity =(int) Math.ceil(MAX_SIZE/DEFAULT_LOAD_FACTORY)+1;
        map  = new LinkedHashMap<K, V>(capacity,DEFAULT_LOAD_FACTORY,true) {
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                boolean  result = size()> MAX_SIZE;
                System.out.println(result);
                return result;
            }
        };
    }
    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return map.entrySet();
    }

    public synchronized int size() {
        return map.size();
    }

    public synchronized void clear() {
        map.clear();
    }
    public static  void main(String args[]){
        LinkedHashMapTest  m = new LinkedHashMapTest(5);
        m.map.put(1,1);
        m.map.put(2,2);
        m.map.put(3,3);
        System.out.println(m.map.toString());
        m.map.put(4,4);
        m.map.put(2,22);
        m.map.put(5,5);
        m.map.put(6,6);
        m.map.put(7,7);
        System.out.println(m.map.toString());
    }


}
