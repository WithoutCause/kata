package me.sjl.netty.container.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;
import me.sjl.netty.container.netty.request.MiniRequest;
import me.sjl.netty.container.netty.response.MiniResponse;
import me.sjl.netty.container.netty.servlet.MiniServlet;

import java.util.Map;

public class MiniHandler extends ChannelInboundHandlerAdapter {

    private final Map<String, MiniServlet> servletMapping;

    public MiniHandler(Map<String, MiniServlet> servletMapping) {
        this.servletMapping = servletMapping;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            MiniRequest miniRequest = new MiniRequest(ctx, request);
            MiniResponse miniResponse = new MiniResponse(ctx);

            String uri = request.uri();
            if (servletMapping.containsKey(uri)) {
                servletMapping.get(uri).service(miniRequest, miniResponse);
            } else {
                miniResponse.write("404 - NotFound");
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
