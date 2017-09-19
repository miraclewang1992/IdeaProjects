/**
 * Created by doshest on 2017/1/12.
 */
public class SonClass extends ParentClass {
    static{
        System.out.println("son");
    }
    int a =5;
    static int b =50;
    int[] c ={1,2};
    public void print_a(){
        System.out.println(a);
    }
    public static void print_b(){
        System.out.println("son"+b);
    }
}
