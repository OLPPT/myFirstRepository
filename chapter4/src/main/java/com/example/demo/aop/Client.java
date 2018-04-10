package com.example.demo.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * Created by OL-PC on 2018/03/21.
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBefore());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("jack");
    }
}
