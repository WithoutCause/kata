package me.sjl.netty.container.netty.servlet;

import me.sjl.netty.container.netty.request.MiniRequest;
import me.sjl.netty.container.netty.response.MiniResponse;

public class ServletTwo extends MiniServlet {
    @Override
    public void doGet(MiniRequest miniRequest, MiniResponse miniResponse) throws Exception {
        doPost(miniRequest, miniResponse);
    }

    @Override
    public void doPost(MiniRequest miniRequest, MiniResponse miniResponse) throws Exception {
        miniResponse.write("this is two Servlet!!!!!!!!________!!!!!_!_!_!_!");
    }
}
