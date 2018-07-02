package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by OL-PC on 2018/06/12.
 */
public class JdkDynamicProxyTest {
    public static void main(String[] args) {
        OriginInterface target = new OriginImpl();
        OriginInterface proxy = (OriginInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),new OriginProxy(target));
        proxy.testProxy();
    }
}

interface OriginInterface{
    void testProxy();
}
class OriginImpl implements OriginInterface{

    @Override
    public void testProxy() {
        System.out.println("test finish");
    }
}
class OriginProxy implements InvocationHandler{

    private Object target;

    public OriginProxy(OriginInterface target){
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method begin");
        Object result = method.invoke(target,args);
        System.out.println("method end");
        return result;
    }
}