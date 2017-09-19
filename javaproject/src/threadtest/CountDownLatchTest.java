package threadtest;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;

import java.util.concurrent.CountDownLatch;

/**
 * Created by doshest on 2017/8/4.
 */
public class CountDownLatchTest {
    static  CountDownLatch count = new CountDownLatch(2);
    public static void main(String args[]){
        Worker work1 =new Worker();
        Worker work2 =new Worker();
        new Thread(work1).start();
        new Thread(work2).start();
    }
    static  class Worker implements  Runnable{

        @Override
        public void run() {
            System.out.println("worked"+Thread.currentThread().getName());
            count.countDown();
            System.out.println("stoped"+Thread.currentThread().getName());
        }
    }
}
