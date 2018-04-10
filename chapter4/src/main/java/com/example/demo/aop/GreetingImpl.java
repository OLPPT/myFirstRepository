package com.example.demo.aop;

/**
 * Created by OL-PC on 2018/03/21.
 */
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello:" + name);
    }
}
