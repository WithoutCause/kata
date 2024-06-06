package me.sjl.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ClientProxy implements InvocationHandler {

    private ClientMethod clientMethod = new ClientMethod();

    public ClientProxy() {
    }

    public ClientProxy(ClientMethod clientMethod) {
        this.clientMethod = clientMethod;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return clientMethod.execute(method, args);
        }
    }
}
