/**
 * Created by doshest on 2017/1/12.
 */
public class ParentClass {
    static{
        System.out.println("parent");
    }
    int a =10;
    static int b =5;
    int[] c ={1,2,3,6,4,5};
    public void print_a(){
        System.out.println(a);
    }
    public static void print_b(){
        System.out.println("father"+b);
    }
}
