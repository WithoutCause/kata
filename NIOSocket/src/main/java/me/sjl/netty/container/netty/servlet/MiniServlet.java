package me.sjl.netty.container.netty.servlet;

import me.sjl.netty.container.netty.request.MiniRequest;
import me.sjl.netty.container.netty.response.MiniResponse;

public abstract class MiniServlet {

    public void service(MiniRequest request, MiniResponse response) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    public abstract void doGet(MiniRequest request, MiniResponse response) throws Exception;

    public abstract void doPost(MiniRequest request, MiniResponse response) throws Exception;
}
