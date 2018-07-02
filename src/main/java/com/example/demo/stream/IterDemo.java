package com.example.demo.stream;

import java.util.*;

/**
 * Created by OL-PC on 2018/05/21.
 */
public class IterDemo {
    public static void main(String[] args) {
//        list();
        mun();
    }
    public static void list(){
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("234");
        list.add("345");
        list.add("456");
//        Iterator iter = list.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//            iter.remove();
//            System.out.println(list.size());
//        }
//        System.out.println(list);
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()){
            iterator.add("123");
            System.out.println(iterator.next());
            System.out.println(list.size());
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
    public static void mun(){
        Integer int1 = 10;
        Integer int2 = 10;
        Integer int3 = new Integer(10);

        Integer int4 = 129;
        Integer int5 = 129;
        Integer int6 = new Integer(129);

        System.out.println(int1 == int2);

        System.out.println(int2 == int3);

        System.out.println(int4 == int5);
        System.out.println(int5 == int6);
    }
}
