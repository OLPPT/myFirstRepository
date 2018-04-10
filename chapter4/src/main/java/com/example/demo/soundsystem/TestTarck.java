package com.example.demo.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by OL-PC on 2018/03/22.
 */
public class TestTarck {

    public static void main(String[] args) {
        ApplicationContext ac =new AnnotationConfigApplicationContext(CompactDiscConfig.class);
        CompactDisc cd = ac.getBean("blankDisc",CompactDisc.class);
        CompactDisc cd1 = ac.getBean("blankDisc",CompactDisc.class);
        System.out.println(cd == cd1);
    }
}
