package test.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doshest on 2017/8/11.
 */
public class ZhanKai
{

    public static  void main(String args[]){
        Map<String ,Object> a1  =new HashMap();
        Map<String ,Object> a2  =new HashMap();
        Map<String ,Object> a3  =new HashMap();
        a1.put("a12",a2);
        a1.put("a1","a");
        a2.put("a23",a3);
        a2.put("a2","a2");
        a3.put("a33","a3");

        Map<String ,Object> result = new HashMap();
        zhanKai(result,a1,"");
        System.out.println(a1.toString());
        System.out.println(result.toString());


    }
    public static void zhanKai(Map<String ,Object> result,Map<String ,Object> data,String key){
        if(data!=null){
            if (null!=key && !"".equals(key)){
                 key = key+".";
            }
            for(String tmp:data.keySet()){
                boolean flag = data.get(tmp) instanceof  Map;
                String clazz = (data.get(tmp)).getClass().toString();
                if(!flag){
                    result.put(key+tmp,data.get(tmp));
                }else{
                    Map<String ,Object> next = (Map)data.get(tmp);
                    zhanKai(result,next,key+tmp);
                }
            }
        }
    }
}
