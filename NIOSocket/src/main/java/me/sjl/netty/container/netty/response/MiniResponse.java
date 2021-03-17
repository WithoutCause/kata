package me.sjl.netty.container.netty.response;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

import java.nio.charset.StandardCharsets;

public class MiniResponse {

    private ChannelHandlerContext context;

    public MiniResponse(ChannelHandlerContext context) {
        this.context = context;
    }

    public void write(String content) {
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(content.getBytes(StandardCharsets.UTF_8))
        );
        response.headers().set("content-Type", "text-html");

        context.write(response);

        context.flush();

        context.close();
    }

}
