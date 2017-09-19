package threadtest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by doshest on 2017/8/10.
 */
public class ScheduledTest {
    static ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
    public static  void main(String args[]){
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        },6,1,TimeUnit.SECONDS);
    }
}
