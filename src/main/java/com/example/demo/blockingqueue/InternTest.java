package com.example.demo.blockingqueue;

/**
 * Created by OL-PC on 2018/06/11.
 */
public class InternTest {
    public static void main(String[] args) {
        String str1 = new String("hel") + new String("lo");

        String str2 = "hello";
        str1.intern();
        System.out.println(str1 == str2);
    }
}