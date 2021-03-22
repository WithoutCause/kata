package me.sjl.netty.rpc.proxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import me.sjl.netty.rpc.protocol.InvokerProtocol;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcProxy {

    public static <T> T create(Class<T> cls) {
        MethodProxy proxy = new MethodProxy(cls);
        Class[] interfaces = cls.isInterface() ? new Class[]{cls} : cls.getInterfaces();
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), interfaces, proxy);
    }

    private static class MethodProxy implements InvocationHandler {
        private Class<?> clzzz;

        public MethodProxy(Class<?> clzzz) {
            this.clzzz = clzzz;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (Object.class.equals(method.getDeclaringClass())) {
                try {
                    return method.invoke(this, args);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    return null;
                }
            } else {
                return rpcInvoke(proxy, method, args);
            }
        }

        public Object rpcInvoke(Object proxy, Method method, Object[] args) {
            InvokerProtocol protocol = new InvokerProtocol();
            protocol.setClassName(this.clzzz.getName());
            protocol.setMethodName(method.getName());
            protocol.setParams(method.getParameterTypes());
            protocol.setValues(args);

            RpcProxyHandler handler = new RpcProxyHandler();
            EventLoopGroup group = new NioEventLoopGroup();
            Bootstrap client = new Bootstrap();
            try {
                client.group(group)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.TCP_NODELAY, true)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                socketChannel.pipeline()
                                        .addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4))
                                        .addLast("frameEncoder", new LengthFieldPrepender(4))
                                        .addLast("encoder", new ObjectEncoder())
                                        .addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)))
                                        .addLast("handler", handler);
                            }
                        });
                ChannelFuture channelFuture = client.connect("localhost", 18080).sync();
                channelFuture.channel().writeAndFlush(protocol).sync();
                channelFuture.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                group.shutdownGracefully();
            }
            return handler.getResponse();
        }

    }



}
