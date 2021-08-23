package me.sjl.imdemo.server.handler;

import io.netty.channel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    List<Channel> channels = new ArrayList<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channels.add(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("这是收到的消息:" + s);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        for (Channel channel : channels) {
            channel.writeAndFlush(content);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        for (Channel channel : channels) {
            channel.writeAndFlush(content);
        }
    }

    public void sendMessage(String message) {
        channels.forEach(chanel -> chanel.writeAndFlush(message));
    }
}
