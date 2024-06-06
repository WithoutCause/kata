package me.sjl.proxy.jdk;

import java.lang.reflect.Proxy;

public class ClientFactory {

    private ClientProxy clientProxy;

    private ClientFactory() {
    }

    private ClientFactory(ClientProxy clientProxy) {
        this.clientProxy = clientProxy;
    }

    public <T> T create(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, clientProxy);
    }

    public static ClientFactoryBuilder builder() {
        return new ClientFactoryBuilder();
    }

    public static class ClientFactoryBuilder {
        private ClientMethod clientMethod;

        public ClientFactoryBuilder clientMethod(ClientMethod clientMethod) {
            this.clientMethod = clientMethod;
            return this;
        }
        public ClientFactory build() {
            ClientProxy clientProxy;
            if (clientMethod == null) {
                clientProxy = new ClientProxy();
            } else {
                clientProxy = new ClientProxy(clientMethod);
            }
            return new ClientFactory(clientProxy);
        }
    }

}
