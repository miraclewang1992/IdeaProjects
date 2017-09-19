package reflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by doshest on 2017/6/8.
 */
public class ReflectTest2 {
    public static void main(String args[]) throws Exception{
      /*  People p1 =new People();
        People p2 =new People();
        p1.setName("xiaoming");
        p2.setName("xiaoming");
        System.out.println(p1.equals(p2));*/
       test1();
    }

    public static void test1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz =loader.loadClass("reflectTest.People");
        Constructor cons = clazz.getDeclaredConstructor(String.class,Integer.class,boolean.class);

        People p =(People)cons.newInstance("11",222,false);
        System.out.println(p.toString());

    }
}