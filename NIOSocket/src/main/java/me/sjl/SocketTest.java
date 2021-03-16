package me.sjl;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

    @Test
    public void socketTest() throws IOException {
        ServerSocket socket = new ServerSocket(8888);
        System.out.println("阻塞前====" + System.currentTimeMillis());
        socket.accept();
        System.out.println("阻塞后=====" + System.currentTimeMillis());

    }

    @Test
    public void socketClientTest() throws IOException {
        System.out.println("连接前====" + System.currentTimeMillis());
        Socket socket = new Socket("localhost", 8888);
        System.out.println("连接后====" + System.currentTimeMillis());
        socket.close();
    }

    @Test
    public void socketServerTest() throws IOException {
        System.out.println("开始启动…………");
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bfReader = new BufferedReader(reader);
        String getString = "";
        while (!"".equals(getString = bfReader.readLine())) {
            System.out.println(getString);
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK \n\n".getBytes());
        outputStream.write("<html><body><a href='https://www.baidu.com'>这个链接可以连到百度</a></body></html>".getBytes());

        outputStream.flush();
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }

}
