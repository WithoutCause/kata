package me.sjl.netty.container.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import me.sjl.netty.container.netty.handler.MiniHandler;
import me.sjl.netty.container.netty.servlet.MiniServlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MiniTomcat {

    private static final int PORT = 8888;


    private final Map<String, MiniServlet> mappings = new HashMap<>();

    private final Properties properties = new Properties();

    public MiniTomcat() {
    }

    private void init() {
        // 加载配置文件
        InputStream inputStream = this.getClass().getResourceAsStream("/mini/mini-netty-tomcat.properties");
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

        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new HttpResponseEncoder())
                                    .addLast(new HttpRequestDecoder())
                                    .addLast(new MiniHandler(mappings));
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);


            ChannelFuture future = serverBootstrap.bind(PORT).sync();
            System.out.println("Netty 版 MiniTomcat 已经启动，监听端口:" + PORT);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }


    }

}
