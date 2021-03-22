package me.sjl.netty.rpc.protocol;

import lombok.Data;

@Data
public class InvokerProtocol implements java.io.Serializable {

    /**
     * 类名
     */
    private String className;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 参数类型
     */
    private Class<?>[] params;

    /**
     * 参数列表
     */
    private Object[] values;

}
