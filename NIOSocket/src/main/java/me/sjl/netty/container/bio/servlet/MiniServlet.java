package me.sjl.netty.container.bio.servlet;

import me.sjl.netty.container.bio.request.MiniRequest;
import me.sjl.netty.container.bio.response.MiniResponse;

/**
 * 简易版的 Servlet 实现
 */
public abstract class MiniServlet {

    public void service(MiniRequest request, MiniResponse response) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    public abstract void doGet(MiniRequest miniRequest, MiniResponse miniResponse) throws Exception;

    public abstract void doPost(MiniRequest miniRequest, MiniResponse miniResponse) throws Exception;

}
