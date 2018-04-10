package com.example.demo.ambiguity.model;

import com.example.demo.ambiguity.Dessert;
import com.example.demo.ambiguity.annotation.Cold;
import com.example.demo.ambiguity.annotation.Creamy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by OL-PC on 2018/03/19.
 */
@Component
@Cold
@Creamy
public class IceCream implements Dessert {
    @Override
    public void eat() {
        System.out.println("eat iceCream");
    }
}
