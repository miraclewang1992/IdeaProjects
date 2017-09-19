package threadtest;

/**
 * Created by doshest on 2017/7/20.
 */
public class VolatileTest extends  Thread
{
    volatile  long v1= 0;
    public void set(long l){
        v1= l;
        System.out.println(v1);
    }
    public void incr(){
        v1=v1+1;
        System.out.println(v1);
    }
    public long get(){
        System.out.println(v1);
        return  v1;

    }

    public static  void main(String args[]){
        VolatileTest test =new VolatileTest();
        Thread t  =new Thread(test);
        Thread t1 =new Thread(test);



    }
}
