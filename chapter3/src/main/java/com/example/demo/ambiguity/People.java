package com.example.demo.ambiguity;

import com.example.demo.ambiguity.annotation.Cold;
import com.example.demo.ambiguity.annotation.Creamy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by OL-PC on 2018/03/19.
 */
public class People {
    private Dessert dessert;

    @Autowired
    @Cold
    @Creamy
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
    public void say(){
        this.dessert.eat();
    }
}
