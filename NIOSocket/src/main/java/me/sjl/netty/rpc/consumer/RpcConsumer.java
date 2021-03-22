package me.sjl.netty.rpc.consumer;

import me.sjl.netty.rpc.api.RpcHelloService;
import me.sjl.netty.rpc.api.RpcService;
import me.sjl.netty.rpc.proxy.RpcProxy;

public class RpcConsumer {

    public static void main(String[] args) {
        RpcHelloService rpcHelloService = RpcProxy.create(RpcHelloService.class);
        String hello = rpcHelloService.hello("张三");
        System.out.println(hello);

        RpcService rpcService = RpcProxy.create(RpcService.class);
        System.out.println("6 + 2 = " + rpcService.add(6, 2));
        System.out.println("6 - 2 = " + rpcService.sub(6, 2));
        System.out.println("6 * 2 = " + rpcService.mult(6, 2));
        System.out.println("6 / 2 = " + rpcService.div(6, 2));
    }

}
