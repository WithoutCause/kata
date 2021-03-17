package me.sjl.netty.container.netty.request;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

public class MiniRequest {

    private HttpRequest request;
    private ChannelHandlerContext context;

    public MiniRequest(ChannelHandlerContext context, HttpRequest request) {
        this.context = context;
        this.request = request;
    }

    public String getMethod() {
        return request.method().name();
    }

    public String getUri() {
        return request.uri();
    }

    public String getParameter(String name) {
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(getUri());
        Map<String, List<String>> parameters = queryStringDecoder.parameters();
        List<String> parameterList = parameters.get(name);
        if (parameterList != null && !parameterList.isEmpty()) {
            return parameterList.get(0);
        }
        return null;
    }
}
