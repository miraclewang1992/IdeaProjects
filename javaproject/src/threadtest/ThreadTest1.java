package threadtest;

/**
 * Created by doshest on 2017/7/13.
 */
public class ThreadTest1 extends  Thread
{   int threadNo;
    public static  void main(String args[]) throws InterruptedException {
            ThreadTest1 tt= new ThreadTest1(1);
            ThreadTest1 tt2= new ThreadTest1(2);
            Thread th =new Thread(tt,"a");
            Thread t1 =new Thread(tt2,"b");

            th.start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.start();
    }
    public ThreadTest1(int num){
        this.threadNo = num;
    }
    public void run(){
        synchronized (ThreadTest1.class){
        for(int i=0;i<10000;i++){
            System.out.println("No:"+(Thread.currentThread().getName().equals("a")?"-----------------------"+"a":Thread.currentThread().getName())+":"+i);
        }
        }
    }
}
