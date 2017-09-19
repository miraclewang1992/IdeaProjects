package threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by doshest on 2017/7/27.
 */
public class CallAbleTest implements Callable<Integer> {
   public  static void main(String args[]){
        CallAbleTest test = new CallAbleTest();
        FutureTask<Integer> f  =new FutureTask<Integer>(test) ;
        for (int i =0;i<1000;i++){
            System.out.println("当前运行的线程为"+Thread.currentThread().getName());
            if(i==1){
                new Thread(f,"有数据返回的线程").start();
            }
        }
       try {
           System.out.println("子线程的返回值"+f.get());
       } catch (InterruptedException e) {
           e.printStackTrace();
       } catch (ExecutionException e) {
           e.printStackTrace();
       }
   }
    @Override
    public Integer call() throws Exception {
       int i = 0;
        for (;i<100;i++){
            System.out.println("----------------"+Thread.currentThread().getName());
        }
        return  i;
    }
}
