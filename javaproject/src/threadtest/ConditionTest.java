package threadtest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by doshest on 2017/8/3.
 */
public class ConditionTest{

     static  Lock lock = new ReentrantLock();
     static Condition con = lock.newCondition();
    public static  void main(String args[]) throws InterruptedException {
        Thread t = new Thread(new ConditionWait());
        t.start();
        new Thread(new ConditionSignal()).start();

    }

     static class ConditionWait implements Runnable{
         @Override
         public void run() {


             System.out.println("lock2"+new java.util.Date());
             lock.lock();
             try {
                 con.await();
                 System.out.println("unlock"+new java.util.Date());
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }finally {
                 lock.unlock();
             }
         }

    }

    static class ConditionSignal implements Runnable{
        @Override
        public  void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2"+new java.util.Date());
            lock.lock();
            con.signalAll();
            lock.unlock();
        }

    }
}
