package me.sjl;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

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

    @Test
    public void keySet() throws IOException {

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);

        channel.bind(new InetSocketAddress("localhost", 8888));
        Selector selector = Selector.open();

        SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_ACCEPT);
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            if (key.isReadable()) {
//                readHandler();
            } else if (key.isWritable()) {
//                writeHandler();
            }

        }

    }

}
