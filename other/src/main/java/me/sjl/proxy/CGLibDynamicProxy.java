package me.sjl.proxy;

import com.google.common.collect.Lists;
import jodd.io.StreamUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CGLibDynamicProxy {

    public int foo(int a) {

        return a;
    }

    public static void main(String[] args) {

//        CGLibDynamicProxy cgLibDynamicProxy = new CGLibDynamicProxy();
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(CGLibDynamicProxy.class);
//        enhancer.setCallback(new CgLibDynamicInterceptor(cgLibDynamicProxy));
//
//        CGLibDynamicProxy proxy = (CGLibDynamicProxy)enhancer.create();
//        int foo = proxy.foo(777);
//        System.out.println(foo);

        List<String> list1 = Arrays.asList("1", "2", "3");

        Collection<Long> collect = CollectionUtils.collect(list1, Long::valueOf);
        System.out.println(collect);

        List<Long> transform = Lists.transform(list1, Long::valueOf);
        System.out.println(transform);


    }

}



class CgLibDynamicInterceptor implements MethodInterceptor {

    private CGLibDynamicProxy proxy;


    public CgLibDynamicInterceptor(CGLibDynamicProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before ...........");
        Object result = method.invoke(proxy, objects);
        System.out.println("after ...........");
        return result;
    }
}
