package test;

/**
 * Created by doshest on 2016/10/27.
 */
public class StringTest {
    public static void main(String args[]){
        String str="c";
        switch (str){
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
            default:
                System.out.println("other");
                break;
        }
        String a =new String("a");
        String b =new String("a");
        System.out.println(a.equals(b));
        System.out.println();

    }
}