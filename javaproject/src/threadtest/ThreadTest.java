package threadtest;

/**
 * Created by doshest on 2017/7/7.
 */
public class ThreadTest extends Thread {
    private int threadNo;
    public ThreadTest(int threadNo) {
        this.threadNo = threadNo;
    }
    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 10; i++) {
            new ThreadTest(i).start();
            Thread.sleep(1);
        }
    }

    @Override
    public  void run() {
        synchronized(ThreadTest.class){


        for (int i = 1; i < 100000; i++) {
            System.out.println("No." + threadNo + ":" + i);
        }

        }
    }
}