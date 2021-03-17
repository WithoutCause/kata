package me.sjl;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class NIODemo {


    @Test
    public void serverSocketServer() throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 9999));
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        char[] chars = new char[1024];
        int len;
        while ((len = reader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        reader.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        serverSocketChannel.close();

    }

    @Test
    public void serverSocketClient() throws IOException {
        Socket socket = new Socket("localhost", 9999);
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        writer.write("床前明日光");
        writer.close();
        outputStream.close();
        socket.close();
    }

}
