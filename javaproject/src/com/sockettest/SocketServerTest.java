package com.sockettest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by doshest on 2017/8/18.
 */
public class SocketServerTest {
    public static void main(String args[]) throws IOException {
        ServerSocket server =new ServerSocket(10086);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String text = "";
        while ((text = br.readLine()) != null){
            System.out.println(text);
        }
        socket.shutdownInput();
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(os);
        PrintWriter pw  =new PrintWriter(writer);
        pw.write("欢迎你");
        pw.flush();
        pw.close();
        writer.close();
        os.close();
        br.close();
        isr.close();
        socket.close();
        server.close();


    }
}
