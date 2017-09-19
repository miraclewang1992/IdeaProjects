package threadtest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by doshest on 2017/8/10.
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2,new A());

    public static  void main(String args[]){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        c.await();
                        System.out.println(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);

    }
    static class A implements  Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3);
        }
    }
}
