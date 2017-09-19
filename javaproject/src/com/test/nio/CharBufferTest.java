package com.test.nio;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by doshest on 2017/7/4.
 */
public class CharBufferTest {
    public  static  void main(String args[])throws Exception{

        try (
                RandomAccessFile accessFile = new RandomAccessFile("test.text","rw");
                FileChannel fcin = accessFile.getChannel()
        ) {
            ByteBuffer bb = ByteBuffer.allocate(100);
            while (fcin.read(bb) != -1) {
                bb.flip();  // 操作就绪

                // 由于通道只能获取到字节码，因此必须解码才能正常显示字符
                Charset cn = Charset.forName("UTF-8"); // Windows默认使用UTF-16编码集
                System.out.print(cn.decode(bb));

                bb.clear(); // 操作之后清空就绪
            }
        }


    /*    Charset cn = Charset.forName("GBK");
        CharBuffer cb = CharBuffer.allocate(8);

        cb.put('你');
        cb.put('们');
        cb.put('好');

        cb.flip(); // 在进行任何非清空的操作之前都必须要归位就绪！
        ByteBuffer bb = cn.encode(cb); // 编码

        for (int i = 0; i < bb.capacity(); i++) { // 打印每个字节
            System.out.print(bb.get(i) + ' ' );
        }


        System.out.println("\n" + cn.decode(bb)); // 再对字节序列解码*/
    }


}
