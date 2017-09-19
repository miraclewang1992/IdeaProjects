package reflectTest;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by doshest on 2016/12/22.
 */
public class ReflectTest {
    public static Car initByDefaultConst() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader loader =Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("reflectTest.Car");
        Constructor cons = clazz.getDeclaredConstructor(String.class,int.class);
        Car car = (Car) cons.newInstance();
        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"red");
        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"保时捷");

        return  car;
    }
    public static  Car initByOther() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz =Class.forName("reflectTest.Car");
        Class[] cl ={String.class,String.class};
        Constructor cons = clazz.getDeclaredConstructor(cl);
        Object[] ps ={"红旗","black"};
        Car car = (Car) cons.newInstance(ps);
        return car;
    }
    public static  void getPrivateCsr() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("reflectTest.PrivateCar");
        Object car =  clazz.newInstance();
        Field f = clazz.getDeclaredField("color");
        f.setAccessible(true);
        f.set(car, "red");
        Method method = clazz.getDeclaredMethod("drive", (Class[]) null);
        method.setAccessible(true);
        method.invoke(car, (Object[]) null);

    }


    public static void getFields() throws ClassNotFoundException {
        Class clazz = Class.forName("reflectTest.Car");
        Field[] objs =clazz.getDeclaredFields();
        for(Field obj:objs){
        System.out.println(obj);
        }
    }
    public  static  void  main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        getPrivateCar();
    }

    public static void getPrivateCar() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("reflectTest.PrivateCar");
        Object obj = clazz.newInstance();
        Field field = clazz.getDeclaredField("color");
        field.setAccessible(true);
        field.set(obj,"black");
      /*  Constructor con = clazz.getConstructor(null);*/
        Method method= clazz.getDeclaredMethod("drive",null);
        method.setAccessible(true);
         method.invoke(obj);
    }
}
