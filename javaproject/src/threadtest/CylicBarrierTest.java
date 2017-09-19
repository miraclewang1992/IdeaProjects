package threadtest;


import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;
import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by doshest on 2017/8/4.
 */
public class CylicBarrierTest implements Runnable{
    public static int num =1000;
    private CyclicBarrier  barrier = new CyclicBarrier(num,this);
    private ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap();
    public int i;
    ExecutorService  service = Executors.newFixedThreadPool(num);
    public CylicBarrierTest(int i) {
        this.i = i;
    }

    public static  void main (String argd[]){
        CylicBarrierTest test = new CylicBarrierTest(0);
        test.count();
    }

    private void  count(){

        for(int i =0 ;i < num;i++){

            service.execute(new CylicBarrierTest(i) {
                @Override
                public void run() {
               /*    System.out.println(this.i);*/
                    map.put(""+this.i,this.i);
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        service.shutdown();
/*        new Thread(new Runnable() {
            @Override
            public void run() {
                while (barrier.getParties()>=100)

            }
        });*/

    }

    @Override
    public void run() {
       /* try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }*/


        int sum =0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
           /* System.out.println("key="+entry.getKey()+","+"value="+entry.getValue());*/
            sum=sum+entry.getValue();
        }
        System.out.println("broken"+barrier.getParties());
        System.out.println("waiting"+barrier.getNumberWaiting());
        System.out.println("----------------"+sum);
    }

}
