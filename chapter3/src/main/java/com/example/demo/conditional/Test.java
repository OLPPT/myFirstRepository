package com.example.demo.conditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by OL-PC on 2018/03/19.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MagicConfig.class);
        MagicBean magicBean = (MagicBean) ac.getBean("magic");
        System.out.println(magicBean);
    }
}
