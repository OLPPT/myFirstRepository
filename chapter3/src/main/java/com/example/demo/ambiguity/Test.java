package com.example.demo.ambiguity;

import com.example.demo.ambiguity.config.AppConfig;
import com.example.demo.ambiguity.config.DessertConfig;
import com.example.demo.ambiguity.config.ExpressiveConfig;
import com.example.demo.ambiguity.model.Cake;
import com.example.demo.ambiguity.model.Cookies;
import org.springframework.boot.web.servlet.context.WebApplicationContextServletContextAwareProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by OL-PC on 2018/03/19.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Cookies cake = (Cookies)ac.getBean("cookies");
        System.out.println(cake);
        cake.eat();
    }
}
