package me.sjl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

//    private Client target;
//
//    public DynamicProxy(Client target) {
//        this.target = target;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("666");
        return proxy;
    }

    public static void main(String[] args) {
        Object o = Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), Client.class.getInterfaces(), new DynamicProxy());
        System.out.println(o);
    }
}


interface Client<T> {

    T execute();

}