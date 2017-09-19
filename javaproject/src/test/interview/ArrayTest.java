package test.interview;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by doshest on 2017/8/11.
 */
public class ArrayTest {
    public static  void main(String args[]){
        Map[] m =new HashMap[3];

        m[0].put("key01","value01");
        m[0].put("key02","value02");

        m[1].put("key11","value11");
        m[1].put("key12","value12");

        m[2].put("key21","value21");
        m[2].put("key22","value22");
    }
    public static void store(Map[] data){

    }
}
