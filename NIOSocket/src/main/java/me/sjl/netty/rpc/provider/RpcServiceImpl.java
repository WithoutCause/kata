package me.sjl.netty.rpc.provider;

import me.sjl.netty.rpc.api.RpcService;

public class RpcServiceImpl implements RpcService {
    /**
     * 加法
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 减法
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    /**
     * 乘法
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int mult(int a, int b) {
        return a * b;
    }

    /**
     * 除法
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int div(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
}
