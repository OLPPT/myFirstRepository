package com.example.demo.ambiguity.config;

import com.example.demo.ambiguity.model.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by OL-PC on 2018/03/19.
 */
@Configuration
@PropertySource("classpath:app.properties")
public class ExpressiveConfig {
    @Autowired
    Environment environment;
    @Bean("${cake.height}")
    @Primary
    public Cake cake(){
        return new Cake(Double.parseDouble(environment.getProperty("cake.height")),
                Double.parseDouble(environment.getProperty("cake.width")));
    }
}
