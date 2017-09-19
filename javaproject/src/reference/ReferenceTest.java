package reference;

import java.lang.ref.SoftReference;

/**
 * Created by doshest on 2016/12/21.
 */
public class ReferenceTest {
    public  static  void main(String args[]){
        Object object = new Object();
        SoftReference<Object[]> objs =new SoftReference<Object[]>(new Object[100]);
        Object[] objArr = objs.get();
        SoftReference<User> soft =new SoftReference<User>(new User());
        User u =soft.get();
        System.out.println(u.hashCode());
        u=new User();
        System.out.println(u.hashCode());
    }
}
