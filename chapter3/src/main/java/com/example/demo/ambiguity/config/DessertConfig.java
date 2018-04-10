package com.example.demo.ambiguity.config;

import com.example.demo.ambiguity.model.Cake;
import com.example.demo.ambiguity.model.Cookies;
import com.example.demo.ambiguity.People;
import com.example.demo.ambiguity.model.IceCream;
import com.example.demo.ambiguity.model.Popsicle;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by OL-PC on 2018/03/19.
 */
@Configuration
@ComponentScan(basePackages = "com.example.demo.ambiguity")
public class DessertConfig {

    @Bean
    public Cake cake(){
        return new Cake(1.2,1.2);
    }

//    @Bean()
//    public Cookies cookies(){
//        return new Cookies();
//    }

    @Bean
    public IceCream iceCream(){
        return new IceCream();
    }

    @Bean
    public  Popsicle popsicle(){
        return new Popsicle();
    }
//    @Bean
//    public PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
//        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
//        p.setLocation(new ClassPathResource("/app.properties"));
//        return p;
//    }
    @Bean("prop")
    public PropertiesFactoryBean propertiesFactoryBean(){
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocations(new ClassPathResource("/app.properties"));
        return propertiesFactoryBean;
    }
    @Bean(name = "people")
    public People people(){
        return new People();
    }
}
