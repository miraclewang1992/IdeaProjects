package test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by doshest on 2016/10/20.
 */
public class ThreadHashMap {
    ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
    Thread t=new Thread(
            new Runnable() {
                @Override
                public void run() {

                }
            }
    );
}
