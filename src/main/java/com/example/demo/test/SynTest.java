package com.example.demo.test;

/**
 * Created by OL-PC on 2018/06/15.
 */
public class SynTest {
    public synchronized void methodA(){
        try {
            Thread.sleep(1000);
            System.out.println("methodA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void methodB(){
        System.out.println("methodB");
    }
    public static void main(String...args){
        SynTest object = new SynTest();
        object.methodA();
        object.methodB();
    }

}
