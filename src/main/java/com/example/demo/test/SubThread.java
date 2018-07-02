package com.example.demo.test;

/**
 * Created By yangkun 2018-6-13
 */
public class SubThread {
    public static void main(String...args){
        new AThread().start();
    }
}
class AThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread A Start!");
        Thread thread = new BThread();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread A Finish!");
    }
}
class BThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread B Start!");
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread B Finish!");
    }
}

