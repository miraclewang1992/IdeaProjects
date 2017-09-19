package threadtest;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by doshest on 2017/8/10.
 */
public class SemaphoreTest {
    public static final int THREAD_NUM = 30;
    static ExecutorService service  = Executors.newFixedThreadPool(THREAD_NUM);
    static Semaphore s = new Semaphore(10);
    public static  void main(String args[]){

        for (int i = 0 ;i<THREAD_NUM;i++){
           service.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       s.acquire();
                       System.out.println("save data");
                       System.out.println(s.availablePermits());
                       s.release();


                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }
           });

        }
        service.shutdown();
    }
}
