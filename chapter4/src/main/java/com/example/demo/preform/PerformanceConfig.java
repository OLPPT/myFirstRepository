package com.example.demo.preform;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by OL-PC on 2018/03/21.
 */
@Configuration
@EnableAspectJAutoProxy
public class PerformanceConfig {
    @Bean("p")
    public PerformanceA performanceA(){
        return new PerformanceA();
    }

    @Bean
    public Audience audience(){
        return new Audience();
    }
}
