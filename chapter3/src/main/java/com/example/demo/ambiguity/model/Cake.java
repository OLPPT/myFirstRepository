package com.example.demo.ambiguity.model;

import com.example.demo.ambiguity.Dessert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OL-PC on 2018/03/19.
 */
public class Cake implements Dessert {
    private double height;
    private double width;

    public Cake(double height, double width) {
        this.height = height;
        this.width = width;
    }
    static List<Map<String,String>> eats = new ArrayList<>();
    static {
        Map<String,String> map1 = new HashMap<>();
        map1.put("title","sweet");
        map1.put("name","bread");
        Map<String,String> map2 = new HashMap<>();
        map2.put("title","suck");
        map2.put("name","coffee");
        Map<String,String> map3 = new HashMap<>();
        map3.put("title","smell terrible");
        map3.put("name","shit");
        List<Map<String,String>> result= new ArrayList<>();
        result.add(map1);
        result.add(map2);
        result.add(map3);
        eats = result;
    }

    public List<Map<String,String>> getEats(){
        return eats;
    }

    @Override
    public void eat() {
        System.out.println("eat cake: height="+this.height+"width:"+this.width);
    }

    @Override
    public String toString() {
        return "Cake{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
