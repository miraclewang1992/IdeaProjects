package threadtest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by doshest on 2017/7/27.
 */
public class ExecutorTest implements Runnable{
    static int tmp =0;
    static CountDownLatch count = new CountDownLatch(100);
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String args[]){

        ExecutorService service = Executors.newCachedThreadPool();
        int i =0;
        while(i<100){

            service.execute(new ExecutorTest());
        /*    try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            i++;
        }
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("+++++++++++++++++++++++++++++"+tmp);
    }

    @Override
    public void run() {

        for (int i = 0;i<1000;i++){
            tmp++;
            atomicInteger.getAndIncrement();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count.countDown();
    }
}
