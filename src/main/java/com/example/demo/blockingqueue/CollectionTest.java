package com.example.demo.blockingqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by OL-PC on 2018/06/07.
 */
public class CollectionTest {
    public static void main(String[] args) {
        testAsList();
//        testAsList2();
    }
    public static void testAsList(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(list);
        list.set(1,9);
        System.out.println(Arrays.toString(list.toArray()));
//        list.add(6);
//        System.out.println(Arrays.toString(list.toArray()));
    }
    public static void testAsList2(){
        List<Snow> snow1 = Arrays.asList(new Crusty(),new Slush(),new Powder());
        List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());
        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,new Light(),new Heavy());
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(),new Heavy());
    }

}
class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}
