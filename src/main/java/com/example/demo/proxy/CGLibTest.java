package com.example.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by OL-PC on 2018/06/12.
 */
public class CGLibTest {
    public static void main(String[] args) {
        ShipProxy proxy = new ShipProxy();
        Ship ship = (Ship) proxy.getProxy(Ship.class);
        ship.travel();
    }
}
class Ship{
    public void travel(){
        System.out.println("航行ing");
    }
}
class ShipProxy implements MethodInterceptor{

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class c){
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin travel...");
        methodProxy.invokeSuper(o,objects);
        System.out.println("end travel...");
        return null;
    }
}
