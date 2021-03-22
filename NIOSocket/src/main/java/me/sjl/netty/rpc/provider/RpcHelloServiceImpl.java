package me.sjl.netty.rpc.provider;

import me.sjl.netty.rpc.api.RpcHelloService;

public class RpcHelloServiceImpl implements RpcHelloService {
    /**
     * 返回 name + "你好！"
     *
     * @param name
     * @return
     */
    @Override
    public String hello(String name) {
        return name + "你好!";
    }
}
