package threadtest;

/**
 * Created by doshest on 2017/7/13.
 */
public class ThreadTest4 extends  Thread
{   int threadNo;
    public static  void main(String args[]) throws InterruptedException {
        ThreadTest4 tt= new ThreadTest4(1);
        ThreadTest4 tt2= new ThreadTest4(2);
        Thread th =new Thread(tt,"a");
        Thread t1 =new Thread(tt,"b");

        th.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
    }
    public ThreadTest4(int num){
        this.threadNo = num;
    }

    public  void run(){
        synchronized(this) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("No:" + (Thread.currentThread().getName().equals("a") ? "-----------------------" + "a" : Thread.currentThread().getName()) + ":" + i);
            }
        }
    }
}
