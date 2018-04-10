package com.example.demo.ambiguity.model;

import com.example.demo.ambiguity.Dessert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OL-PC on 2018/03/19.
 */
@Component
@PropertySource({"classpath:app.properties"})
public class Cookies implements Dessert {

    @Value("#{cookies.eats.^[title eq 'suck'].get('name')}")
    private String smell;
    @Value("${cookies.taste}")
    private String taste;

//    public Cookies( String smell,  String taste) {
//        this.smell = smell;
//        this.taste = taste;
//    }
    List<Map<String,String>> eats = new ArrayList<>();

    public List<Map<String,String>> getEats(){
        Map<String,String> map1 = new HashMap<>();
        map1.put("title","sweet");
        map1.put("name","bread");
        Map<String,String> map2 = new HashMap<>();
        map2.put("title","suck");
        map2.put("name","coffee");
        Map<String,String> map3 = new HashMap<>();
        map3.put("title","suck");
        map3.put("name","shit");
        List<Map<String,String>> result= new ArrayList<>();
        result.add(map1);
        result.add(map2);
        result.add(map3);
        return result;
    }
    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public void eat() {
        System.out.println("eat cookies");
    }

    @Override
    public String toString() {
        return "Cookies{" +
                "smell='" + smell + '\'' +
                ", taste='" + taste + '\'' +
                '}';
    }
}
