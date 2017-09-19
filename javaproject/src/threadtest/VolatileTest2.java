package threadtest;

/**
 * Created by doshest on 2017/7/20.
 */
public class VolatileTest2
{
    volatile   static  int i = 0;
    public static void incr() throws InterruptedException {
        Thread.sleep(1);
        i++;
    }
    public static  void main(String args[]){
        for(int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        VolatileTest2.incr();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println(i);

    }
}
