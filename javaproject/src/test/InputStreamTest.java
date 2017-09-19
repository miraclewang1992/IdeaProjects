package test;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.*;

/**
 * Created by doshest on 2016/12/8.
 */
public class InputStreamTest
{
    public static  void main(String args[]){
        try {
            InputStream is = new FileInputStream(new File("test.text"));
            byte b[]=new byte[2];
            int f=0;
            while ((f=is.read(b))!=-1){
                String s=new String(b,0,f);
                System.out.println(s);
            }
            is.close();

 /*           int num=0;
            InputStream is1=new FileInputStream(new File("test.text"));
            while((num=is1.read())!=-1){
                System.out.println((char)num);
            }
            InputStream is2=new BufferedInputStream(is1);
            while((num=is2.read())!=-1){
                System.out.println((char)num);
            }
            //字符流
            BufferedReader br =new BufferedReader(new FileReader("test.text"));

            String line=null;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
            // 字节流转为字符流
            InputStream is3=new FileInputStream(new File("test.text"));
            InputStreamReader isr=new InputStreamReader(is3);
            char []cha = new char[20];
            int len=-1;
            while((len =isr.read(cha))!=-1){
                System.out.print(new String(cha,0,len));
            }
            isr.close();
            byte[] a={1,2,3,4,5,6};
            OutputStream os =new FileOutputStream(new File("test.text"));
            OutputStreamWriter writer = new OutputStreamWriter(os);
            FileWriter fw =new FileWriter("test.text",true);
            BufferedInputStream bis1=new BufferedInputStream(is);
            PrintWriter pw = new PrintWriter(new FileWriter("test.text",true),true);
            pw.write("中华人民共和过");
            pw.flush();
            pw.close();
            File f =new File("test.txt");
            if(f.exists()==false){
                f.createNewFile();
            }
            OutputStream ost = new FileOutputStream(f,true);
            ost.write("hello".getBytes(),0,5);
            ost.flush();
            ost.close();*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
