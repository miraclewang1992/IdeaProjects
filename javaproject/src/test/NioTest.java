package test;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by doshest on 2016/10/11.
 */
public class NioTest {
        public static  void main(String args[])throws  IOException{
            FileInputStream fis = new FileInputStream("D:\\IdeaProjects\\javaproject\\src\\catalina.out");
            FileChannel fc=fis.getChannel();

            ByteBuffer buffer= ByteBuffer.allocate(1024*1024*6);
            int j=0;
            while(true){
                buffer.clear();
                int flag=fc.read(buffer);
                System.out.println(flag);
                if(flag==-1){
                    break;
                }
                buffer.flip();
                OutputStream os;
                FileOutputStream fos=new FileOutputStream((j++)+".out");
                FileChannel fcout= fos.getChannel();
                fcout.write(buffer);
                fos.flush();
                fos.close();
            }

        }

}
