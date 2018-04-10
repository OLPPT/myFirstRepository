package com.example.demo.preform;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by OL-PC on 2018/03/21.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(PerformanceConfig.class);
        Performance performance = (Performance) ac.getBean("p");
        performance.perform();
    }
}
