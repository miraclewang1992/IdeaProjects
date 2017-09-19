package com.io;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;

/**
 * Created by doshest on 2017/8/2.
 */
public class Zijieliu
{
        public static  void main(String args[]) throws IOException {
        /*    try {
                FileInputStream fi  =new FileInputStream(new File("test.txt"));
                byte b[] = new byte[12];
                while(fi.read(b)!=-1){
                    System.out.println(new String(b));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/


          /*  StringReader sr = new StringReader("北京市人民政府");
            char b[] =new char[10];
            try {
                while(sr.read(b)!=-1){
                    System.out.println(new String(b));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            /*InputStreamReader isr = new InputStreamReader(new FileInputStream("test.text"));
            char b[] =new char[12];
            while (isr.read(b)!=-1){
                System.out.println(new String(b));

            }*/
/*            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.text")));
            String tmp;
            while ((tmp = br.readLine())!=null){
                System.out.println(tmp);
            }
            br.close();*/
            RandomAccessFile raf = new RandomAccessFile("D://abc.txt", "rw");
            raf.setLength(1024*1024); // 预分配 1M 的文件空间
            raf.close();

            // 所要写入的文件内容
            String s1 = "第一个字符串";
            String s2 = "第二个字符串";
            String s3 = "第三个字符串";
            String s4 = "第四个字符串";
            String s5 = "第五个字符串";

            // 利用多线程同时写入一个文件
            new FileWriteThread(1024*1,s1.getBytes()).start(); // 从文件的1024字节之后开始写入数据
            new FileWriteThread(1024*2,s2.getBytes()).start(); // 从文件的2048字节之后开始写入数据
            new FileWriteThread(1024*3,s3.getBytes()).start(); // 从文件的3072字节之后开始写入数据
            new FileWriteThread(1024*4,s4.getBytes()).start(); // 从文件的4096字节之后开始写入数据
            new FileWriteThread(1024*5,s5.getBytes()).start(); // 从文件的5120字节之后开始写入数据
        }
    static class FileWriteThread extends Thread{
        private int skip;
        private byte[] content;

        public FileWriteThread(int skip,byte[] content){
            this.skip = skip;
            this.content = content;
        }

        public void run(){
            RandomAccessFile raf = null;
            try {
                raf = new RandomAccessFile("test.txt", "rw");
                raf.seek(skip);
                raf.write(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    raf.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
