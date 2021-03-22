package me.sjl.netty.rpc.api;

public interface RpcService {

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    int add(int a, int b);

    /**
     * 减法
     * @param a
     * @param b
     * @return
     */
    int sub(int a, int b);

    /**
     * 乘法
     * @param a
     * @param b
     * @return
     */
    int mult(int a, int b);

    /**
     * 除法
     * @param a
     * @param b
     * @return
     */
    int div(int a, int b);

}
