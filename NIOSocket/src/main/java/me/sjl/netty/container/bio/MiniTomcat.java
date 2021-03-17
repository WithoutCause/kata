package me.sjl.netty.container.bio;

import me.sjl.netty.container.bio.request.MiniRequest;
import me.sjl.netty.container.bio.response.MiniResponse;
import me.sjl.netty.container.bio.servlet.MiniServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MiniTomcat {

    private static final int PORT = 8888;

    private ServerSocket serverSocket;

    private final Map<String, MiniServlet> mappings = new HashMap<>();

    private final Properties properties = new Properties();

    public MiniTomcat() {
    }

    private void init() {
        // 加载配置文件
        InputStream inputStream = this.getClass().getResourceAsStream("/mini/mini-tomcat.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Object k : properties.keySet()) {
            String key = k.toString();
            if (key.endsWith(".uri")) {
                String uri = properties.getProperty(key);
                String replace = key.replace(".uri", "");
                String className = replace + ".className";
                String servletClassName = properties.getProperty(className);
                try {
                    MiniServlet servlet = (MiniServlet) Class.forName(servletClassName).newInstance();
                    mappings.put(uri, servlet);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void start() {
        init();

        System.out.println("MiniTomcat 已经启动，监听羊端口:" + PORT);

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket client;
            try {
                client = serverSocket.accept();
                process(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void process(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        MiniRequest request = new MiniRequest(inputStream);
        MiniResponse response = new MiniResponse(outputStream);

        String url = request.getUrl();
        if (mappings.containsKey(url)) {
            try {
                mappings.get(url).service(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.write("404 - Not Found");
        }
        outputStream.flush();
        outputStream.close();

        inputStream.close();
        socket.close();
    }
}
