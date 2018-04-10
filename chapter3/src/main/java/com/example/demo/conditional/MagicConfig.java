package com.example.demo.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by OL-PC on 2018/03/19.
 */
@Configuration
public class MagicConfig {
    @Bean(name = "magic")
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean(){
        MagicBean magicBean = new MagicBean();
        magicBean.setName("hshs");
        magicBean.setType("type");
        return magicBean;
    }
}
