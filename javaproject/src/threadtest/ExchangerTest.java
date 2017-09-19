package threadtest;
import java.util.concurrent.*;
/**
 * Created by doshest on 2017/8/10.
 */
public class ExchangerTest {
    static Exchanger e = new Exchanger();
    static ExecutorService service  =Executors.newFixedThreadPool(2);
    public  static void main(String args[]){
        service.execute(new Runnable() {
            @Override
            public void run() {
                String A ="this is string a";
                try {
                    System.out.println("AAA");
                   A = (String) e.exchange(A);
                    System.out.println("1."+A);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("BBB");
                String B ="this is string b";
                try {
                    String A = (String) e.exchange(B);
                    System.out.println(A);
                    System.out.println(A.equals(B));
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
