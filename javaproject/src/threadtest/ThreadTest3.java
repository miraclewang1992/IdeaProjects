package threadtest;

/**
 * Created by doshest on 2017/7/13.
 */
public class ThreadTest3 extends  Thread
{   int threadNo;
    public static  void main(String args[]) throws InterruptedException {
        ThreadTest1 tt= new ThreadTest1(1);
        ThreadTest1 tt2= new ThreadTest1(2);
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
    public ThreadTest3(int num){
        this.threadNo = num;
    }
    public synchronized void print(){
        for(int i=0;i<100000;i++){
            System.out.println("No:"+(Thread.currentThread().getName().equals("a")?"-----------------------"+"a":Thread.currentThread().getName())+":"+i);
        }
    }
    public void run(){
        print();
    }
}
