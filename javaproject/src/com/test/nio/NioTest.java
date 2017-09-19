package com.test.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by doshest on 2017/7/4.
 */
public class NioTest {
    public static  void main(String args[]) throws  Exception{
        RandomAccessFile aFile = new RandomAccessFile("test.txt","rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        CharBuffer charBuffer = CharBuffer.allocate(10);

        int bytesRead = channel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = channel.read(buf);
        }
        aFile.close();


    }
}
