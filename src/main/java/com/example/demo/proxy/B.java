package com.example.demo.proxy;

/**
 * Created by OL-PC on 2018/06/12.
 */
public class B extends A {
    public int a = 3;
    public B(){}
    public int getInfo(){
        int tempa = super.a;
        int tempb = this.a;
        return tempa;
    }
}
