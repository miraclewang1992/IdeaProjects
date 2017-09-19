package threadtest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by doshest on 2017/7/25.
 */
public class concurrentHashMapTest {
    public static void main(String args[]) throws InterruptedException {
        final Map m = new ConcurrentHashMap();
        Thread t  =new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<10000;i++){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            m.put(UUID.randomUUID(),"");
                        }
                    }).start();
                }
            }
        },"test");
        t.start();
        t.join();

        for (Object obj:m.keySet()){
            System.out.println(obj.toString());
        }
        System.out.println(m.keySet().size());

    }
}
