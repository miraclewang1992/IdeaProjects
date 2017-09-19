package threadtest;

import java.util.concurrent.*;

/**
 * Created by doshest on 2017/8/1.
 */
public class ForkJoinTest extends RecursiveTask<Integer> {
    private static  final int HODL = 2;
    private  int start;
    private int end;
    public ForkJoinTest(int start,int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        boolean flag = (end-start)<=HODL;
        if(flag){
            for(int i =start;i<=end;i++){
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum+=i;
            }
        }else{

            int middle = (end+start)/2;
            ForkJoinTest test1 = new ForkJoinTest(start,middle);
            ForkJoinTest test2 = new ForkJoinTest(middle+1,end);
            test1.fork();
            test2.fork();
            int result = test1.join();
            int result1= test2.join();

            sum = result + result1;
        }
        return sum;
    }
    public static void main(String args[]){
        ForkJoinPool pool  = new ForkJoinPool();
        ForkJoinTest task = new ForkJoinTest(1,4);

        Future<Integer> result = pool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
