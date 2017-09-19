/**
 * Created by doshest on 2017/1/12.
 */
public class Test {
    public static void main(String[] args){
        Parent p = new Parent();
        Parent son = new Son();
        p.getName();
        son.getName();
        p.getDesc();
        son.getDesc();
    }
}
class Parent{
    public static String name ;
    public String desc;
    public static void getName(){
        name = "father";
        System.out.println(name);
    }
    public void getDesc(){
        desc = "father's Desc";
        System.out.println(desc);
    }
}

class Son extends Parent{
    public static void getName(){
        name = "son";
        System.out.println(name);
    }
    public void getDesc(){
        desc = "son's Desc";
        System.out.println(desc);
    }
}
