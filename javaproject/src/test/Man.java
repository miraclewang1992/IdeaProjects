package test;

/**
 * Created by doshest on 2016/10/26.
 */
public class Man extends Person {
    String name="man";
    public void say(){
        System.out.println("I an man");
    }
    public void work(){
        System.out.println(super.name);
    }
}