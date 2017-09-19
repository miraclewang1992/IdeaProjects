package threadtest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by doshest on 2017/8/3.
 */
public class WaitTest implements  Runnable{
    public static void main(String args[]){
        Executor task = Executors.newCachedThreadPool();
        WaitTest test = new WaitTest();
        for(int i =0;i<10;i++){

            task.execute(new WaitTest());
            new Thread(new TestWa()).start();
        }


    }

    @Override
    public   void run() {
        synchronized(WaitTest.class){
            System.out.println(new java.util.Date());
            try {
               /* WaitTest.class.wait();*/
               Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end timfe"+new java.util.Date());
        }


    }
    static class TestWa implements Runnable{

        @Override
        public void run() {
            synchronized (WaitTest.class){
                WaitTest.class. notifyAll();
            }
        }
    }
}
