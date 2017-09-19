package test;

/**
 * Created by doshest on 2016/10/26.
 */
public class MainTest {
    public  static  void main(String args[]){
        Person p=new Man();
        System.out.println(p.name);
        p.say();
        p.work();
    }
}
