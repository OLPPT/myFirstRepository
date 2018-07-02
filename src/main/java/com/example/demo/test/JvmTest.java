package com.example.demo.test;

/**
 * Created by OL-PC on 2018/06/15.
 */
public class JvmTest {

    public static void main(String[] args) {
        System.out.println(Sub.b);
    }

    static class Parent{
        public static int a = 1;
        static {
            a = 2;
        }
    }
    static class Sub extends Parent{
        public static int b = a;
    }
}
