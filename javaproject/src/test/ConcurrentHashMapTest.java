package test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by doshest on 2016/10/20.
 */
public class ConcurrentHashMapTest {
    public static void main(String args[]){
        ConcurrentHashMap map = new ConcurrentHashMap();
        for(int i=0;i<10000;i++){
            map.put(i,i);
            System.out.println(map.get(i));
        }
    }
}
