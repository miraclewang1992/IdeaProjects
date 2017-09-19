package threadtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by doshest on 2017/7/31.
 */
public class WaitNotify {
    private static Object obj =new Object();
    private static boolean flag = true;
    public static void main(String args[]){
        Thread t1 =new Thread(new Wait());
        Thread t2 =new Thread(new Notify());
        t1.start();
        t2.start();
    }
    static class Wait implements Runnable{
        public void run() {
            synchronized (obj){
                while (flag){
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"wait1");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"wait2");
                }
            }
        }
    }

    static class Notify implements Runnable{
        public void run() {
            synchronized (obj){
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"notify1");
                flag =false;
                obj.notify();
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"notify2");
            }
        }
    }
}
