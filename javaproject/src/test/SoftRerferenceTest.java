package test;

import java.lang.ref.SoftReference;

/**
 * Created by doshest on 2016/10/10.
 */
public class SoftRerferenceTest {
    public static  void main(String args[]){
        System.out.println("开始");
        A a=new A();
        SoftReference<A> sr=new SoftReference<A>(a);
        a=null;
        if(sr!=null){
            System.out.println("1");
            a=sr.get();
            if(a==null){
                System.out.println(3);
            }
        }else{
            System.out.println("2");
            a=new A();
            sr=new SoftReference<A>(a);
        }
    }
}
class A{
    int[] a;
    public A(){
        a=new int[100000000];
    }
}
