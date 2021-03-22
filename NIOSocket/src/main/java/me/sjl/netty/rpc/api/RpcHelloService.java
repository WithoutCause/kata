package me.sjl.netty.rpc.api;

/**
 * @author sjl
 */
public interface RpcHelloService {

    /**
     * 返回 name + "你好！"
     * @param name
     * @return
     */
    String hello(String name);

}
