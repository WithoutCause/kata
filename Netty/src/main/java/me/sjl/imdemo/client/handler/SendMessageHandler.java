package me.sjl.imdemo.client.handler;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Scanner;

public class SendMessageHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        new Thread(() -> {
            System.out.println("请在控制台输入内容......");
            Scanner scanner = new Scanner(System.in);
            ChannelFuture channelFuture = null;
            do {
                if (scanner.hasNext()) {
                    String input = scanner.nextLine();
                    channelFuture = ctx.channel().writeAndFlush(input);
                }

            } while (channelFuture != null);

        }).start();

    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("上海自来水来自海上ok12,收到的消息" + s);
        System.out.println("1");
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
    }


}
